package kr.or.ddit.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

// 스프링에게 자바빈으로 등록해달라는 요청
@Slf4j
@Controller
@RequestMapping("/springNotice")
public class SpringNoticeController {

	// 3) 공지사항 목록 요청
	// 요청 URI : /springNotice/list
	@GetMapping("/list")
	public String list() {
		log.info("list : 누구나 접근 가능");	
		// views > springNotice > list.jsp를  forwarding
		return "springNotice/list";
	}
	
	
	// 4) 공지사항 등록 요청
	// 요청 URI : /springNotice/register
	@GetMapping("/register")
	public String register() {
		log.info("공지사항 등록 요청 : 로그인 한 관리자만 접근 가능");
		// views > springNotice > register.jsp를  forwarding
		return "springNotice/register";
	}
}
