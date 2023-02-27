package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.Board;

public interface IBaordService {
	public void register(Board board) throws Exception;
	
	public List<Board> list() throws Exception;

	public Board read(int boardNo) throws Exception;
	
	public void update(Board board) throws Exception;
}
