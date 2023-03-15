package kr.or.ddit.controller.board;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.Board;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/crud/board")
public class CrudBoardController {

	@Inject
	private IBoardService boardService;
	
	// 빈이 등록되고 초기화 단계에서 바로 확인해야할 때
	@PostConstruct
	public void init() {
		// aopProxy 상태 확인(interface 기반 프록시)
		log.info("aopProxy  상태 : (interface 기반) : {} " + AopUtils.isAopProxy(boardService));
		// aopProxy 상태 확인(클래스 상속 기반 프록시)
		log.info("aopProxy  상태 : (class 상속 기반) : {} " + AopUtils.isCglibProxy(boardService));
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String crudRegisterForm(Board board, Model model) {
		log.info("crudRegisterForm() : ");
		model.addAttribute("board",board);
		return "crud/register";
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String crudRegister(@Validated Board board, BindingResult result, Model model) throws Exception {
		log.info("crudRegister() : ");
		
		// 등록 기능 요청(서비스)
		boardService.register(board);
		
		if(board.getBoardNo()>0) {
			// 띄어쓰기 있으면 안됨
			return "redirect:/crud/board/read?boardNo=" + board.getBoardNo();
		}
		model.addAttribute("msg","등록 완료");
		return "crud/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String crudList(Model model) throws Exception {
		log.info("crudList() : ");
		
		List<Board> boardList = boardService.list();
		model.addAttribute("list", boardList);
		return "crud/list";
	}
	
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public String crudRead(int boardNo, Model model) throws Exception {
		log.info("crudRead() : ");
		
		Board board = boardService.read(boardNo);
		model.addAttribute("board", board);
		return "crud/read";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String crudModifyForm(int boardNo, Model model) throws Exception {
		log.info("crudModifyForm() : ");

		Board board = boardService.read(boardNo);
		model.addAttribute("board",board);
		model.addAttribute("status","u");
		return "crud/register";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String crudModify(@Validated Board board, BindingResult result, Model model) throws Exception {
		log.info("crudModify() : ");
		
		// 등록 기능 요청(서비스)
		boardService.update(board);
		model.addAttribute("msg","수정 완료");
		return "crud/success";
	}
	
	@RequestMapping(value = "/remove",method = RequestMethod.POST)
	public String crudRemove(int boardNo, Model model) throws Exception {
		log.info("crudRemove()");
		boardService.remove(boardNo);
		model.addAttribute("msg","삭제 끝");
		return "crud/success";
	
	}
	

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String crudSearch(String title, Model model) throws Exception {
		log.info("crudSearch() : ");
		
		Board board = new Board();
		board.setTitle(title);
		
		List<Board> boardList = boardService.search(board);
		
		model.addAttribute("board",board);
		// jsp와 컨트롤러의 키 값이 일치해야지 값이 넘어옴,,
		model.addAttribute("list",boardList);
		
		return "crud/list";
	}
}
