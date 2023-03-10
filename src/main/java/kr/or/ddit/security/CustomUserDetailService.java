package kr.or.ddit.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailService implements UserDetailsService{
	
	// DI(의존성 주입)
	// IMemberService : 화이자
	// CustomUserDetailService : 사람
	// << 이미 있는 사람에게 화이자를 주입함.
	@Inject
	private MemberMapper mapper;
	// usernmame은 사용자 아이디. 로그인 화면에서 입력된 아이디의 값을 말함.
	// <input type="text" name="username" value="2" placeholder="아이디를 입력해주세요"/>
	// 파라미터 {username=2,password=1234}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("username : " + username);
		
		MemberVO memberVO  = mapper.select(Integer.parseInt(username));
		log.info("memberVO : "  + memberVO);

		// null 회원 아이디에 해당하는 회원이 없을 때
		// User는 UserDetails와 부모와 자식의 관계. 스프링 시큐리티에서 제공
		
		return memberVO==null?null:new CustomUser(memberVO);
	}

}
