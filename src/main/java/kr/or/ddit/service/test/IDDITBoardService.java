package kr.or.ddit.service.test;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.test.DDITBoardVO;

public interface IDDITBoardService {

	public List<DDITBoardVO> list() throws Exception;

	public DDITBoardVO read(int boNo) throws Exception;

	public void register(DDITBoardVO board) throws Exception;

	public void update(DDITBoardVO board) throws Exception;

	public void remove(int boNo) throws Exception;

	public List<DDITBoardVO> search(Map<String, String> map) throws Exception;


}
