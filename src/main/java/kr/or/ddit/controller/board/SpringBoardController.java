package kr.or.ddit.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

// 스프링한테 이거는 컨트롤러야라고 알려줘야함
// 스프링은 자바빈(객체)으로 등록 > 스타트하면 메모리에 올라감

@Slf4j
@Controller
@RequestMapping("/springBoard")
public class SpringBoardController {
	
	/*
	 * 1. 게시판 목록 요청 (누구나 접근 가능)
	 * 요청 URL : /board/list
	 */
	@GetMapping("/list")
	public String list() {
		log.info("list : 누구나 접근 가능");	
		// views > springBoard > list.jsp를  forwarding
		return "springBoard/list";
	}
	
	/* 
	 * 2. 게시판 등록 요청 (로그인한 회원만 접근 가능)
	 * 요청 URL : /board/register
	 */
	@GetMapping("/register")
	public String register() {
		log.info("list : 로그인한 회원만 접근 가능");	
		// views > springBoard > register.jsp 를 forwarding 
		return "springBoard/register";
	}
}
