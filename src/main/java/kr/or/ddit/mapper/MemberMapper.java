package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.MemberAuth;
import kr.or.ddit.vo.MemberVO;

public interface MemberMapper {

	public void create(MemberVO member) throws Exception;

	public void createAuth(MemberAuth memberAuth) throws Exception;

	public List<MemberVO> list() throws Exception;

	public MemberVO read(int userNo) throws Exception;

	public void update(MemberVO member) throws Exception;

	public void deleteAuth(int userNo) throws Exception;

	public void delete(int userNo) throws Exception;
	
	// 스프링에서 로그인에 사용할 Select 문
	//<select id="select" parameterType="int" resultMap="loginMap">
	public MemberVO select (int userNo);

}
