package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.Board;

// 인터페이스여서 어노테이션은 필요 없음
public interface BoardMapper {
	
	// 메서드만 정의
	public void create(Board board) throws Exception;
	
	public List<Board> list() throws Exception; 
	
	public Board read(int boardNo) throws Exception;

	public void update(Board board) throws Exception;
	
}
