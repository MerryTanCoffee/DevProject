package kr.or.ddit.security;

import java.util.Collection;
import java.util.stream.Collectors;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.ddit.vo.MemberVO;

public class CustomUser extends User {

	private MemberVO memberVO;
	
	public CustomUser(String username, String password, 
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);

	}

	// 생성자
	// 사용자가 정의한 MemberVO 타입을 스프링 시큐리티의 UserDetails 타입으로 변환
	// memberVO.getAuthList() : List<MemberAuth> authList
	//							Set<GrantedAuthority> authorities	
	public CustomUser(MemberVO memberVO) {
		// 사용자 아이디, 비밀번호, 권한 리스트(memberVO.getAuthList())
		super(memberVO.getUserName(), memberVO.getUserPw(),
				memberVO.getAuthList().stream()
				.map(auth->new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList())
				);
	// authList = [MemberAuth(userNo=2, auth=ROLE_ADMIN, MemberAuth(userNo=2, auth=ROLE_MEMBER)]	
		this.memberVO = memberVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
}
