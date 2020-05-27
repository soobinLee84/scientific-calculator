package com.celeb.site.comment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celeb.site.comment.dao.CommentDao;
import com.celeb.site.comment.service.CommentService;
import com.celeb.site.comment.vo.CommentVo;
import com.celeb.site.common.util.WebHelper;

import lombok.extern.log4j.Log4j;
@Log4j
@Service
public class commentServiceImpl implements CommentService {
	@Autowired
	CommentDao CommentDao;

	@Autowired
	WebHelper web;

	@Override
	public void insertComment(CommentVo comment) throws Exception {
		// 댓글 추가기능
		try {
			int result = CommentDao.insertComment(comment);
			if (result == 0) {
				throw new Exception();
			}
		} catch (NullPointerException e) {
			throw new Exception("저장된 댓글이 없습니다.");
		
		}catch (Exception e ) {
			log.error(e.getLocalizedMessage());
			throw new Exception("댓글 저장을 실패하였습니다");
		}

	}
	
}
