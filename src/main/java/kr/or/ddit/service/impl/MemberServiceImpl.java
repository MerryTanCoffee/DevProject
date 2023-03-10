package kr.or.ddit.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.MemberAuth;
import kr.or.ddit.vo.MemberVO;

@Service
public class MemberServiceImpl implements IMemberService{

	@Inject
	private MemberMapper mapper;
	
	@Override
	public void register(MemberVO member) throws Exception {
		mapper.create(member);
		
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_USER");
		
		mapper.createAuth(memberAuth);
	}

	@Override
	public List<MemberVO> list() throws Exception {
		return mapper.list();
	}

	@Override
	public MemberVO read(int userNo) throws Exception {
		return mapper.read(userNo);
	}

	@Override
	public void modify(MemberVO member) throws Exception {
		mapper.update(member);
		
		int userNo = member.getUserNo();
		// 기존 권한 삭제
		mapper.deleteAuth(userNo);
		List<MemberAuth> authList = member.getAuthList();
		
		for(int i = 0; i < authList.size(); i++) {
			// 새로운 권한 추가
			MemberAuth memberAuth = authList.get(i);
			String auth = memberAuth.getAuth();
			if(auth == null) {
				continue;
			}
			if(auth.trim().length() == 0) {
				continue;
			}
			memberAuth.setUserNo(userNo);
			mapper.createAuth(memberAuth);
		}
		
	}

	@Override
	public void remove(int userNo) throws Exception {
		mapper.deleteAuth(userNo);
		mapper.delete(userNo);
	}

	
	// 스프링에서 로그인에 사용할 Select 문
	@Override
	public MemberVO select (int userNo) {
		return this.mapper.select(userNo);
	}
}
