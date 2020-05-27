package com.celeb.site.comment.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.celeb.site.board.vo.BoardVo;
import com.celeb.site.comment.service.CommentService;
import com.celeb.site.comment.vo.CommentVo;
import com.celeb.site.common.util.RegexHelper;
import com.celeb.site.common.util.WebHelper;
import com.celeb.site.member.vo.MemberVo;

@Controller
public class commentController {
	private static final Logger logger = LoggerFactory.getLogger(commentController.class);
	@Autowired
	WebHelper web;

	@Autowired
	CommentService commentservice;

	@Autowired
	SqlSession sqlSession;

	@Autowired
	CommentVo comment;
	
	@Autowired
	MemberVo member;
	
	@Autowired
	BoardVo board;

	@Autowired
	RegexHelper regex;
	
	

	
	@ResponseBody
	@RequestMapping(value = "/CommentWriteOk.do", method = RequestMethod.POST)
	public String CommentWriteOk(Locale locale, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		web.init();

		/* 로그인 여부 검사 */
		MemberVo loginInfo = (MemberVo) web.getSession("loginInfo");
	
		if (loginInfo == null) {
			String movePage = web.getRootPath() + "/login.do";
			web.redirect(movePage, "로그인 후에 이용해 주세요.");
			return null;
		}

		/* 뷰에서 넘어오는 파라미터 받기 */
		String content = web.getString("content");
		int boardIdx = web.getInt("boardIdx");
		String ipAddress = web.getClientIP();

		/* log 찍어보기 */
		logger.info("content = " + content);
		logger.info("boardIdx = " + boardIdx);
		logger.info("ipAdress = " + ipAddress);

		/* 입력된 값의 유효성 검사 */

		if (!regex.isValue(content)) {
			web.redirect(null, "댓글의 내용 입력하세요");
			return null;
		}
	

		if (content.length() > 21844) {
			web.redirect(null, "입력 할 수 있는 텍스트길이를 초과 했습니다.");
			return null;
		}

		/* 전달받은 파라미터 Beans 객체에 담는다 */
		CommentVo commentVo = new CommentVo();
		commentVo.setUserId(loginInfo.getUserId());
		commentVo.setContent(content);
		commentVo.setBoardIdx(boardIdx);
		commentVo.setUserIdx(loginInfo.getUserIdx());
		commentVo.setIpAddress(ipAddress);
		
		
		
		/* Service를 통한 데이터 베이스 저장처리 */
		try {
			commentservice.insertComment(comment);;
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			// 예외가 발생한 경우이므로, 더이상 진행하지 않는다.
			return null;
		}

		/* 저장 되었으므로 조회 페이지로 이동 */
		web.redirect(web.getRootPath() + "/detail.do?"+ boardIdx , "저장 완료 되었습니다.");

		return null;
	}
	

	@RequestMapping(value = "/tms.do", method = RequestMethod.GET)
	public String tms(Locale locale, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		web.init();
		
		return "tms";
	}
	
	
}
