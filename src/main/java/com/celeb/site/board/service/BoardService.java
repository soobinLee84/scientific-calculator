package com.celeb.site.board.service;

import java.util.List;

import com.celeb.site.board.vo.BoardVo;
import com.celeb.site.member.vo.MemberVo;

public interface BoardService {
	
	/**
	 * 게시물 목록 조회
	 *
	 * @return 조회 결과에 대한 컬렉션
	 * @throws Exceotion
	 */
	public List<BoardVo> getBoardList(BoardVo board) throws Exception;
	
	/**
	 * 게시물 등록하기
	 * @param board 저장할 정보를 담고있는 VO
	 * @author soobin
	 *
	 */
	public void addBoard(BoardVo board) throws Exception;
	
	/**
	 * 게시물 상세 조회
	 * @param board 조회할 게시물의 일련번호를 담고있는 Vo
	 * @return 조회된 데이터가 저장된 Vo
	 * @throws Exception
	 */
	public BoardVo getBoardItem(BoardVo board) throws Exception;
	
	/**
	 * 게시물 수정
	 * @param board 수정할 게시물의 내용과 일련번호를 담고있는 vo
	 * @throws Exception
	 */
	
	public void modifyBoard(BoardVo board) throws Exception;
	
	/**
	 * 게시물 삭제하기
	 * @param board 저장할 정보를 담고있는 VO
	 * @throws Exception
	 */
	public void deleteBoard(BoardVo board) throws Exception;
	
	
	/**
	 * 게시물 전체 개수
	 * @return
	 * @throws Exception
	 */
	public int totalBoardPage(BoardVo board) throws Exception;
	
	
	/**
	 * 게시글 조회수 카운트
	 * @param board
	 * @throws Exception
	 */
	
	public void updateCount(BoardVo board) throws Exception;


}
