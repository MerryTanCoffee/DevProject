package kr.or.ddit.controller.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.service.test.IDDITBoardService;
import kr.or.ddit.vo.test.DDITBoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ddit/board")
public class DDITBoardController {

	@Inject
	private IDDITBoardService boardService;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String dditRegisterForm(DDITBoardVO board, Model model) {
		log.info("dditRegisterForm() : ");
		model.addAttribute("board",board);
		
		return "dditboard/register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String dditRegister(DDITBoardVO board, Model model) throws Exception {
		log.info("dditRegister() : ");
		
		// 등록 기능 요청(서비스)
		boardService.register(board);
		
		if(board.getBoNo()>0) {
			// 띄어쓰기 있으면 안됨
			return "redirect:/ddit/board/read?boNo=" + board.getBoNo();
		}
	
		model.addAttribute("msg","등록 완료");
		return "dditboard/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardList(Model model) throws Exception{
		log.info("boardList : ");
		List<DDITBoardVO> boardList = boardService.list();
		model.addAttribute("list",boardList);
		return "dditboard/list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String boardRead(int boNo, Model model) throws Exception {
		log.info("boardRead() : ");
		
		DDITBoardVO board = boardService.read(boNo);
		model.addAttribute("dditBoard",board);
		
		return "dditboard/detail";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String dditModifyForm(int boNo, Model model) throws Exception {
		log.info("dditModifyForm() : ");

		DDITBoardVO board = boardService.read(boNo);
		model.addAttribute("board",board);
		model.addAttribute("status","u");
		return "dditboard/register";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String dditModify(DDITBoardVO board, Model model) throws Exception {
		log.info("dditModify() : ");
		
		// 등록 기능 요청(서비스)
		boardService.update(board);
		model.addAttribute("msg","수정 완료");
		return "dditboard/success";
	}
	
	@RequestMapping(value = "/remove",method = RequestMethod.POST)
	public String dditRemove(int boNo, Model model) throws Exception {
		log.info("dditRemove()");
		boardService.remove(boNo);
		model.addAttribute("msg","삭제 끝");
		return "dditboard/success";
	
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String dditSearch(@RequestParam("searchType") String type,
							 @RequestParam("searchWord") String word,
							 Model model) throws Exception {
		log.info("dditSearch() : ");
		
		
		DDITBoardVO board = new DDITBoardVO();
		Map<String,String> map = new HashMap<>();
		map.put("searchType", type);
		map.put("searchWord", word);
		
		List<DDITBoardVO> boardList = boardService.search(map);
		
		model.addAttribute("board",board);
		model.addAttribute("type",type);
		// jsp와 컨트롤러의 키 값이 일치해야지 값이 넘어옴,,
		model.addAttribute("list",boardList);
		
		return "dditboard/list";
	}			
}
