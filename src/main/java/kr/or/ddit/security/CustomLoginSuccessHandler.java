package kr.or.ddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

// 사용자 정의 로그인 성공 처리자 : 로그인 성공 시 실행
@Slf4j
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws ServletException, IOException {
		log.warn("로그인 성공 시 실행");
		
		// 로그인 했다는 계정정보가 있다는 의미
		// prinvipal : 로그인 시 계정 정보를 갖고 있음.
		// UserDetail : 클래스(username, password, 권한)와 밀접함
		User customUser = (User)auth.getPrincipal();
		
		log.info("username : " + customUser.getUsername());
		super.onAuthenticationSuccess(request, response, auth);
	}
}
