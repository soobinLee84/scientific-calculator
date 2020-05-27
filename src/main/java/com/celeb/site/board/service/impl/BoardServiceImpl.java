package com.celeb.site.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.celeb.site.board.dao.BoardDao;
import com.celeb.site.board.service.BoardService;
import com.celeb.site.board.vo.BoardVo;
import com.celeb.site.common.util.WebHelper;
import com.celeb.site.member.dao.MemberDao;
import com.celeb.site.member.vo.MemberVo;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	MemberDao memberDao;

	@Autowired
	BoardDao BoardDao;

	@Autowired
	WebHelper web;
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public List<BoardVo> getBoardList(BoardVo board) throws Exception {
		//메모리스트 조회
		List<BoardVo> result = null;
		
		
		
		try {
			result = BoardDao.getBoardList(board);

			if (result == null) {
				throw new NullPointerException();
			}

		} catch (NullPointerException e) {
			throw new Exception("조회된 게시글이 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("게시글 조회를 실패하였습니다.");
		}
		return result;
	}
	
	@Override
	public BoardVo getBoardItem(BoardVo board) throws Exception {
		// 게시판 단일 조회 (detail view)
		BoardVo bvo = null;
		
		try {
		bvo = BoardDao.getBoarditem(board);
			if (bvo == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
				throw new Exception("조회된 게시판이 없습니다.");
		}catch(Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("게시판 조회를 실패하였습니다.");
		}
		
		return bvo;
	}
	

	@Override
	public void addBoard(BoardVo board) throws Exception {
		// 게시판 저장

		try {
			int result = BoardDao.addBoard(board);
			if (result == 0) {
				throw new NullPointerException();

			}

		} catch (NullPointerException e) {
			throw new Exception("저장된 게시물이 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("게시물 저장을 실패하였습니다.");
		}
		
	}

	@Override
	public void modifyBoard(BoardVo board) throws Exception {
		// 게시판수정
		
		int result = BoardDao.editBoard(board);
		
	}

	@Override
	public void deleteBoard(BoardVo board) throws Exception {
		//게시판삭제
		try {
		int result = BoardDao.deleteBoard(board);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			throw new Exception ("존재하지 않는 게시물을 사제할 수 없습니다.");
		}catch(Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("게시물 삭제에 실패 했습니다.");
		}
	}

	@Override
	public int totalBoardPage(BoardVo board) throws Exception {
		//메모 전체개수 조회
		int result = 0;
		
		try {
			result = BoardDao.totalBoardPage(board);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("전체 개수 조회를 실패하였습니다.");
		}

		
		
		return result;
	}

	@Override
	public void updateCount(BoardVo board) throws Exception {
		
		
		 BoardDao.updateCount(board);
		
		
		
	}





	
}