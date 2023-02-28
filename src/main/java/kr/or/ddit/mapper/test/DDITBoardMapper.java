package kr.or.ddit.mapper.test;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.test.DDITBoardVO;
import kr.or.ddit.vo.test.DDITTagVO;

public interface DDITBoardMapper {

	public List<DDITBoardVO> list() throws Exception;

	public DDITBoardVO read(int boNo) throws Exception;

	public void create(DDITBoardVO board) throws Exception;

	public void incrementHit(int boNo) throws Exception;

	public void update(DDITBoardVO board) throws Exception;

	public void remove(int boNo) throws Exception;
	
	public void removeTag(int boNo) throws Exception;

	public List<DDITBoardVO> search(Map<String, String> map) throws Exception;

	public void createTag(DDITTagVO tag) throws Exception;

}
