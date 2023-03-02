package kr.or.ddit.controller.noticeboard.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeInsertController {

	/*
	 * 입력 페이지를 관여
	 */
	@Autowired
	private INoticeService noticeService;
	
	@RequestMapping(value="/form.do", method=RequestMethod.GET)
	public String noticeForm() {
		return"notice/form";
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String noticeInset(NoticeVO noticeVO, Model model) {
		String goPage = "";
		Map<String, String> errors = new HashMap<String,String>();
		
		if(StringUtils.isBlank(noticeVO.getBoTitle())) {
			errors.put("boTitle", "제목 입력 필");
		}
		
		if(StringUtils.isBlank(noticeVO.getBoContent())) {
			errors.put("boContent", "내용 입력 필");
		}
		
		if(errors.size() > 0) { // 에러가 있음
			model.addAttribute("errors",errors);
			model.addAttribute("notice",noticeVO);
			goPage = "notice/form";
		} else {
			noticeVO.setBoWriter("a001");
			ServiceResult result = noticeService.insertNotice(noticeVO);
			if(result.equals(ServiceResult.OK)) {
				goPage = "redirect:/notice/detail.do?boNo=" +noticeVO.getBoNo();
			} else {
				errors.put("message", "서버 에러 다시 시도");
				model.addAttribute("errors",errors);
				goPage = "notice/form";
			}
		}
		return goPage;
	}
}
