package kr.or.ddit.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.controller.board.BoardRecordNotFoundException;
import kr.or.ddit.mapper.BoardMapper;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.Board;

@Service
public class boardServiceImpl implements IBoardService{

	// DAO 대신  Mapper를 부름
	@Inject
	private BoardMapper mapper;
	
	// 에러가 나는 경우에 트랜잭션 처리를 해라
	@Transactional(propagation = Propagation.REQUIRED, 
			rollbackFor = {RuntimeException.class, Error.class, SQLException.class, NullPointerException.class})
	@Override
	public void register(Board board) throws Exception {
		
		// 이 부분 없으면 데이터가 사라짐
		mapper.create(board);
		
		if(true) {
			throw new SQLException();
		}
	}

	@Override
	public List<Board> list() throws Exception {
		return mapper.list();
	}

	@Override
	public Board read(int boardNo) throws Exception {
		
		Board board = mapper.read(boardNo);
		
		if(board==null) {
			throw new BoardRecordNotFoundException("Not Found boardNo = " + boardNo);
		}
		
		return board;
	}

	@Override
	public void update(Board board) throws Exception {
		
		mapper.update(board);
	}

	@Override
	public void remove(int boardNo) throws Exception {
		mapper.remove(boardNo);		
	}

	public List<Board> search(Board board) throws Exception  {
		return mapper.search(board);
	}

}
