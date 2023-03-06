package kr.or.ddit.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.controller.noticeboard.web.TelegramSendController;
import kr.or.ddit.mapper.LoginMapper;
import kr.or.ddit.mapper.NoticeMapper;
import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;
import kr.or.ddit.vo.test.DDITMemberVO;

@Service
public class NoticeServiceImpl implements INoticeService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private LoginMapper loginMapper;
	
	TelegramSendController tst = new TelegramSendController();
	
	@Override
	public ServiceResult insertNotice(NoticeVO noticeVO) {
		ServiceResult result = null;
		int status = noticeMapper.insertNotice(noticeVO);
		if(status > 0) { // 성공
			try {
				tst.sendGet("지선", noticeVO.getBoTitle());
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = ServiceResult.OK;
		} else { // 실패
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public NoticeVO selectNotice(int boNo) {
		
		noticeMapper.incrementHit(boNo);
		
		return noticeMapper.selectNotice(boNo);
	}

	@Override
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO) {
	
		return noticeMapper.selectNoticeCount(pagingVO);
	}

	@Override
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO) {

		return noticeMapper.selectNoticeList(pagingVO);
	}

	@Override
	public ServiceResult updateNotice(NoticeVO notice) {
		
		ServiceResult result = null;
		int cnt = noticeMapper.updateNotice(notice);
		if(cnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ServiceResult deleteNotice(int boNo) {
		
		ServiceResult result = null;
		int cnt = noticeMapper.deleteNotice(boNo);
		if(cnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ServiceResult idCheck(String memId) {
		ServiceResult result = null;
		DDITMemberVO member = loginMapper.idCheck(memId);
	
		if(member != null) {
			result = ServiceResult.EXIST;
		} else {
			result = ServiceResult.NOTEXIST;
		}
		
		return result;
	}

	@Override
	public ServiceResult signup(DDITMemberVO memberVO) {
		
		ServiceResult result = null;
		int status = loginMapper.signup(memberVO);
	
		if(status > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}


	@Override
	public DDITMemberVO loginCheck(DDITMemberVO member) {
		return loginMapper.loginCheck(member);
	}

	@Override
	public String findId(DDITMemberVO member) {
		return loginMapper.findId(member);
	}

	@Override
	public String findPw(DDITMemberVO member) {
		return loginMapper.findPw(member);
	}
}
