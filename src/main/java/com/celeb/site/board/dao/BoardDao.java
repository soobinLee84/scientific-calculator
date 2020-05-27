package com.celeb.site.board.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.celeb.site.board.vo.BoardVo;
import com.celeb.site.common.sqlSessionDaoSupport.CommonSqlSessionDaoSupport;
import com.celeb.site.member.vo.MemberVo;

@Repository("MemoDao")
public class BoardDao extends CommonSqlSessionDaoSupport {

	
	@Autowired
	BoardVo board ;
	
	@Autowired
	MemberVo member;
	
 private Logger logger = LoggerFactory.getLogger(BoardDao.class);

	
 	public int addBoard(BoardVo board) throws Exception {
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + logger);
		return getSqlSession().insert("BoardMapper.addBoard", board);
	}

	public  List<BoardVo> getBoardList(BoardVo board) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + logger);
		System.out.println(">>>>>>>>>>>>>>>>>>>>" + board.toString());
		return getSqlSession().selectList("BoardMapper.getBoardList", board);
	}
	
	public  BoardVo getBoarditem(BoardVo board) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>>>" + logger);
		return getSqlSession().selectOne("BoardMapper.getBoardItem", board);
			
	}
	
	public int editBoard(BoardVo board) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>>>" + logger);
		return getSqlSession().update("BoardMapper.editBoard", board);
			
	}
	
	public int deleteBoard(BoardVo board) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + logger);
		return getSqlSession().delete("BoardMapper.deleteBoard", board);
	}
	
	
	public int totalBoardPage(BoardVo board) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + logger);
		System.out.println(">>>>>>>>>>>>>>>>>>>>" + board.toString());
		return getSqlSession().selectOne("BoardMapper.totalBoardPage", board);
	}
	
	public int  updateCount(BoardVo board) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>>>" + logger);
		return getSqlSession().update("BoardMapper.updateCount", board);
			
	}
	
	public int addComment(BoardVo board) throws Exception {
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + logger);
		return getSqlSession().insert("BoardMapper.addComment", board);
	}
	
	
}