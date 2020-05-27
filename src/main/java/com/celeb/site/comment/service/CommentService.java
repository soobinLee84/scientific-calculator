package com.celeb.site.comment.service;


import com.celeb.site.comment.vo.CommentVo;

public interface CommentService {
	/**
	 * 댓글을 저장한다
	 * @param comment - 댓글내용
	 * @throws Exception
	 * @author soobinLee
	 */
	public void insertComment(CommentVo comment) throws Exception;
}
