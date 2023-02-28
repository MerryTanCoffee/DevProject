package kr.or.ddit.service.test;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.test.DDITBoardMapper;
import kr.or.ddit.vo.test.DDITBoardVO;
import kr.or.ddit.vo.test.DDITTagVO;


@Service
public class DDITboardServiceImpl implements IDDITBoardService{

	@Inject
	DDITBoardMapper mapper;
	
	@Override
	public List<DDITBoardVO> list() throws Exception {
		return mapper.list();
	}

	@Override
	public DDITBoardVO read(int boNo) throws Exception {
		DDITBoardVO board = mapper.read(boNo);
		mapper.incrementHit(boNo);
		return board;
	}

	@Override
	public void register(DDITBoardVO board) throws Exception {
		// 이 부분 없으면 데이터가 사라짐
		mapper.create(board);
		
		
		List<DDITTagVO> tagList = board.getTagList();
		for(int i = 0; i < tagList.size(); i++) {
			DDITTagVO tagVO = new DDITTagVO();
			tagVO.setBoNo(board.getBoNo());
			tagVO.setTagName(board.getTagList().get(i).getTagName());
			mapper.createTag(tagVO);
		}
	}

	@Override
	public void update(DDITBoardVO board) throws Exception  {
		
		mapper.update(board);		
		
		int boNo = board.getBoNo();
		mapper.removeTag(boNo);
		List<DDITTagVO> tagList = board.getTagList();
		
		for(int i = 0; i < tagList.size(); i++) {
			DDITTagVO tagVO = tagList.get(i);
			String tag = tagVO.getTagName();
			if(tag == null) {
				continue;
			} 
			if(tag.trim().length() == 0) {
				continue;
			}
			tagVO.setBoNo(boNo);
			mapper.createTag(tagVO);
		}
	}

	@Override
	public void remove(int boNo) throws Exception {
	
		mapper.removeTag(boNo);
		mapper.remove(boNo);	
	}


	@Override
	public List<DDITBoardVO> search(Map<String, String> map) throws Exception {
		return mapper.search(map);
	}

}
