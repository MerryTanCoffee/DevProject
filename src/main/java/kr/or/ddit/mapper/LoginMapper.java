package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.test.DDITMemberVO;

public interface LoginMapper {

	public DDITMemberVO idCheck(String memId);

	public int signup(DDITMemberVO memberVO);

	public DDITMemberVO loginCheck(DDITMemberVO member);

	public List<DDITMemberVO> findId(DDITMemberVO memberVO);

}
