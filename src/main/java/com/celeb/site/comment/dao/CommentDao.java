package com.celeb.site.comment.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.celeb.site.comment.vo.CommentVo;
import com.celeb.site.common.sqlSessionDaoSupport.CommonSqlSessionDaoSupport;



@Repository("CommentDao")
public class CommentDao extends CommonSqlSessionDaoSupport {

	@Autowired
	CommentVo comment ;

 private Logger logger = LoggerFactory.getLogger(CommentVo.class);
 
 public int insertComment(CommentVo comment) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + comment.toString());
		return getSqlSession().insert("CommentMapper.insertComment", comment);
	}
 
}
