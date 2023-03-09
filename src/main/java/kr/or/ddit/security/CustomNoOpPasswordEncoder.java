package kr.or.ddit.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

// 비밀번호 암호화를 하지 않겠다는 의미
// 스프링 시큐리티 5부터는 기본적으로 passwordEncoder를 지정해야함
// users 테이블에 비밀번호를 암호화하여 저장하지 않았으므로
// 여기서도 비밀번호를 암호화하지 않음
@Slf4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		log.info("before encode : " + rawPassword);
		
		// 암호화를 하지 않고 문자 그대로 리턴한다는 의미
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}

}
