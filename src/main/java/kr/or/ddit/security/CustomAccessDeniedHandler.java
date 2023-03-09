package kr.or.ddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	// 인터페이스(껍데기)를 구현하는 핸들러(기능)
	// 껍데기를 구현하기 위해서는 꼭 필요한 내용을 포함해야한다.(오버라이드)

	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		log.info("handle");

		// 요청자의 정보를 알 수 있다.
		// 다시 요청 redirect는 response 안에 있음
		response.sendRedirect("/accessError");
	}

}
