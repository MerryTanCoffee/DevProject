package kr.or.ddit.security;



import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {

	
	/* 
	 * ex) /localhost/springNotice/register 요청이 있을 때
	 * member 계정(ROLE_MEBER)으로 로그인 후 접근하고자 한다면
	 * 접근 거부 처리자에 의해 접근 거부 URI(/accessError)로 인터셉트 됨
	 */
	@GetMapping("/accessError")
	public String accessError(Authentication auth, Model model) {

		// 로그인은 했으나 권한이 없으므로 auth에는 접속 장보가 들어있음
		log.info("access Denied : " + auth);
	
		model.addAttribute("msg","접근이 거부됨");
		
		// views > accessError.jsp를 forwarding 함
		return "accessError";
	}
	
	// 요청 URI : /login
	// 오류가 발생된 요청URI : / login?error=1
	// 요청(Request) 파라미터(param) : error=1
	// 로그아웃 후에 다시 로그인 폼으로 돌아올 때의 요청URI : /login?logout=1
	// 요청(Request) 파라미터(param) : logout=1
	// 요청방식 : get
	@GetMapping("/login")
	public String loginForm(@RequestParam(value="error",required=false) String error,
			String logout, Model model) {
		
		log.info("error : " + error); // error : 1
		log.info("logout : " + logout);  // logout : 1
	
		if(error!=null) {
			model.addAttribute("error","로그인 오류 발생");
		} 
		if(logout!=null) {
			model.addAttribute("logout","로그아웃되었습니다.");
		} 
		
		//forwarding
		// views > loginForm.jsp를 forwarding
		
		return "loginForm";
	}
}
