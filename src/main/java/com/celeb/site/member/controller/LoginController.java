package com.celeb.site.member.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
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

import com.celeb.site.common.util.WebHelper;
import com.celeb.site.member.service.MemberService;
import com.celeb.site.member.vo.MemberVo;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	WebHelper web;

	@Autowired
	MemberService memberService;

	@Autowired
	SqlSession sqlSession;

	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		
		return "login";
	}
	
	@RequestMapping(value = "/login_ok.do", method = RequestMethod.POST)
	public String loginOk(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		web.init();

		/* (1) 파라미터 처리 */
		String userId = web.getString("user_id");
		String userPw = web.getString("user_pw");

		logger.debug(">>>userId=" + userId);
		logger.debug(">>>userPw=" + userPw);

		if (userId == null || userPw == null) {
			web.redirect(null, "아이디나 비밀번호가 없습니다.");
			return null;
		}

		/* (2) 전달받은 파라미터를 Beans에 설정한다 */
		MemberVo member = new MemberVo();
		member.setUserId(userId);
		member.setUserPw(userPw);

		/* (3) Service를 통한 회원 인증 */
		MemberVo loginInfo = null;

		try {
			// 아이디와 비밀번호가 일치하는 회원정보를 조회하여 리턴한다.
			loginInfo = memberService.selectLoginInfo(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}

		/* (4) 조회된 회원정보를 세션에 저장 */
		/**
		 * 로그인 처리는 아이디와 비밀번호를 기반으로 조회된 정보를 세션에 보관하는 과정을 말한다. 로그인에 대한 판별은 저장된 세션정보의 존재
		 * 여부를 판별한다.
		 */
		web.setSession("loginInfo", loginInfo);

		/* (5) 페이지 이동 */
		// 이전 페이지 구하기(javascript로 이동된 경우 조회 안됨)
		
		
			//referer : 바로 이전의 url이 request객체에 담아짐
		String movePage = request.getHeader("referer");

		String helloname = loginInfo.getUserName(); 

		if (movePage == null) {
			movePage = web.getRootPath() + "/main.do";
		}
		
		movePage = web.getRootPath() + "/main.do";
		web.redirect(movePage, "로그인 되었습니다" + helloname + "님환영합니다!");
		return null;
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logOut(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		web.init();
		/*(1) 로그인 여부 검사*/
		//로그인중인 회원 정보 가져오기
		MemberVo loginInfo = (MemberVo)web.getSession("loginInfo");
		
		//로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if(loginInfo == null) {
			web.redirect(web.getRootPath()+"/main.do","로그인 후에 이용 가능합니다.");
			return null;
		}
		/*(2) 로그아웃*/
		//로그아웃은 모든 세션 정보를 삭제하는 처리.
		web.removeAllSession();
		
		/*(3) 페이지 이동*/
		web.redirect(web.getRootPath() + "/main.do", "로그아웃 되었습니다.");
		return null;
	}
	
}
