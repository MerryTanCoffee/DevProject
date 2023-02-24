package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/formtag")
public class JSPFormTagController {

	/*
	 * 8장: 스프링 폼 태그
	 * 
	 * 1. 스프링 폼 태그 라이브러리
	 * - 스프링 폼은 HTML 폼을 표시하기 위한 태그 라이브러리이다.
	 * - 스프링 폼을 이용하면 HTML 폼과 자바 객체를 쉽게 바인딩 할 수 있다.
	 * 
	 * # 스프링 폼 커스텀 태그 목록
	 * 
	 * <form:form>
	 * 	- 폼 요소를 생성한다.
	 * <form:input>
	 * 	- 텍스트 필드 요소를 생성한다.
	 * <form:password>
	 * 	- 패스워드 필드 요소를 생성한다.
	 * <form:textarea>
	 *  - 텍스트 영역 요소를 생성한다.
	 * <form:checkboxes>
	 *  - 여러 개의 체크박스 요소를 생성한다.
	 * <form:checkbox>
	 *  - 체크 박스 요소를 생성한다.
	 * <form:radiobuttons>
	 * 	- 라디오 버튼 요소를 생성한다.
	 * <form:select>
	 *  - 셀렉트 박스 요소를 생성한다.
	 * <form:hidden>
	 *  - 숨겨진 필드 요소를 생성한다.
	 * <form:label>
	 *  - 라벨 요소를 생성한다.
	 * <form:button>
	 *  - 버튼 요소를 생성한다.
	 * <form:errors>
	 *  - 입력 값 검증 오류를 표시한다.
	 * 
	 * # 스프링 폼 태그 라이브러리 선언 방법
	 *  <%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
	 *  
	 * 2. 폼 요소
	 * - HTML 폼을 출력하려면 <form:form> 요소를 사용한다.
	 * 
	 * *** JSP 에서 form:form modelAttribute 속성과 서버 컨트롤러 메소드의
	 * model.addAttribute의 속성명이 같은 상태로 연결이 되어 있어야 페이지 에러가 
	 * 발생하지 않는다. (브라우저의 JSP 페이지와 서버의 컨트롤러 메소드가 같은 속성으로
	 * 묶여 있어야 에러가 발생하지 않는다. 같은 속성으로 묶여 있어야 해당 값들이 정상적으로
	 * 자동 바인딩 될 수 있어 입력값 유효성 검증을 진행할 때 무리가 없기 때문이다.)
	 * 
	 * 3. 폼 항목의 공통 속성
	 * -HTML 폼 항목을 출력하기 위한 태그 라이브러리에는 몇 가지 공통 속성이 있다.
	 * 
	 * 	path 
	 * 	- 폼 항목에 바인딩되는 폼 객체의 프로퍼티를 지정한다.
	 *  disabled
	 *  - 폼 항목을 비활성화할지 여부를 지정한다.
	 *  - 기본 값은 false이다.
	 *  readonly
	 *  - 폼 항목을 읽기 전용으로 만들지 여부를 지정한다.
	 *  - 기본 값은  false 이다.
	 * 
	 */
	
	//1) 모델에 폼 객체를 추가하지 않으면 에러 발생
	@RequestMapping(value = "/registerForm01_Error",method = RequestMethod.GET )
	public String registerForm01_Error() {
		log.info("registerForm01_Error()");
		return "home/formtag/registerForm01_Error";
	}
	
	// 2) 폼 객체의 속성명과 스프링 폼 태그의 modelAttribute 속성값이 일치해야 한다.
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		log.info("");
		model.addAttribute("member", new Member());
		return "home/formtag/registerForm02";
	
	}
	
	// 3) 폼 객체의 속성명과 스프링 폼 태그의 modelAttribute 속성값이 일치하지 않으면 에러가 발생한다.
	@RequestMapping(value = "/registerForm03",method = RequestMethod.GET)
	public String registerForm03(Model model) {
		log.info("registerForm03()");
		// 속성 명에 "user"를 지정하고 폼 객체 (자바빈즈 클래스 Member)를 모델에 추가한다.
		model.addAttribute("user",new Member());
		return "home/formtag/registerForm03";
	}
	
	// 4) 폼 객체의 속성명과 스프링 폼 태그의 modelAttribute 속성값이 일치하지 않으면 에러가 발생한다.
	@RequestMapping(value = "/registerForm04",method = RequestMethod.GET)
	public String registerForm04(Model model) {
		log.info("registerForm04()");
		// 속성 명에 "user"를 지정하고 폼 객체 (자바빈즈 클래스 Member)를 모델에 추가한다.
		model.addAttribute("user",new Member());
		return "home/formtag/registerForm04";
	}
	
	// 5) 컨트롤러 메서드의 매개변수로 자바빈즈 객체가 전달이 되면 기본적으로 다시 화면으로 전달한다.
	@RequestMapping(value = "/registerForm05", method = RequestMethod.GET)
	public String registerForm05(Member member) {
		log.info("registerForm05()");
		return "home/formtag/registerForm05";
		
	}
	
	// 6) 폼 객체의 속성명은 직접 지정하지 않으면 폼 객체의 클래스 명의 맨 처음 문자를 소문자로 변환해 처리한다.
	// Member 클래스의 앞 M 을 소문자로 바꾼  member 로 변환해서 처리한다.
	@RequestMapping(value = "/registerForm06", method = RequestMethod.GET)
	public String registerForm06(Member user) {
		log.info("registerForm06()");
		return "home/formtag/registerForm06";
		
	}
	
	// 7) @ModelAttribute 어노테이션 폼 객체의 속성명을 직접 지정할수 있다.
	@RequestMapping(value = "/registerForm07", method = RequestMethod.GET)
	public String registerForm07(@ModelAttribute("user") Member member) {
		log.info("registerForm07() ");
		return "home/formtag/registerForm07";
	}
	
	// 결과 페이지
	@RequestMapping(value ="/register",method = RequestMethod.POST)
	public String register(Member member) {
		log.info("register()");
		log.info("userId : " + member.getUserId());
		log.info("password  : " + member.getPassword());
		
		return "home/formtag/result";
	}
	
	
 }
