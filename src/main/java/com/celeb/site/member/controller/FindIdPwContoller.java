package com.celeb.site.member.controller;

import java.util.Locale;

import javax.mail.MessagingException;
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

import com.celeb.site.common.util.MailHelper;
import com.celeb.site.common.util.RegexHelper;
import com.celeb.site.common.util.Util;
import com.celeb.site.common.util.WebHelper;
import com.celeb.site.member.service.MemberService;
import com.celeb.site.member.vo.MemberVo;


@Controller
public class FindIdPwContoller {
	/* (1) 사용하고자 하는 Helper + Service 객체 선언 */
	private static final Logger logger = LoggerFactory.getLogger(FindIdPwContoller.class);

	@Autowired
	WebHelper web;

	@Autowired
	RegexHelper regex;

	@Autowired
	MemberService memberService;

	@Autowired
	SqlSession sqlSession;
	
	
	@Autowired
	MailHelper mail;
	
	@Autowired
	Util util;

	@RequestMapping(value = "/findId.do", method = RequestMethod.GET)
	public String findId(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		MemberVo loginInfo = (MemberVo) web.getSession("loginInfo");
		if (loginInfo != null) {
			String movePage = web.getRootPath() + "/main.do";
			web.redirect(movePage, "이미 로그인 하셨습니다.");
			return null;
		}

		return "findId";
	}

	@RequestMapping(value = "/findIdOk.do", method = RequestMethod.POST)
	public void findIdOk(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		MemberVo loginInfo = (MemberVo) web.getSession("loginInfo");
		if (loginInfo != null) {
			String movePage = web.getRootPath() + "/main.do";
			web.redirect(movePage, "이미 로그인 하셨습니다.");
		}
		
		String email = web.getString("email");
		
		
		logger.debug("email >>>>>>>>>>>>>>>>>>>>>" + email);
		
		if(email == null) {
			web.redirect(null,"이메일을 입력하세요");
		}
		
		MemberVo member = new MemberVo();
		member.setUserEmail(email);
		
		MemberVo user = null;
		
		try {
			user = memberService.findId(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		
		
		String sender  = "sooblair84@gmail.com";
		String subject = "HiCeleb 아이디찾기 안내 메일입니다.";
		String content = "회원님의 아이디는<strong>" + user.getUserId() + "</strong>입니다";
		
		//메일보내기
		try {
			mail.sendMail(sender, email, subject, content);
		} catch (MessagingException e) {
			web.redirect(null, "메일 발송에 싪패하였습니다");
		}
		
		/*결과*/
		web.redirect(null, "입력하신 이메일로 아이디를 전송하였습니다.");
	}
	
	
	@RequestMapping(value = "/findPw.do", method = RequestMethod.GET)
	public String findPw(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		MemberVo loginInfo = (MemberVo) web.getSession("loginInfo");
	

		return "findPw";
	}
	

		
		@RequestMapping(value = "/findPwOk.do", method = RequestMethod.POST)
	public void findPwOk(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		
		MemberVo loginInfo = (MemberVo) web.getSession("loginInfo");
		if (loginInfo != null) {
			String movePage = web.getRootPath() + "/main.do";
			web.redirect(movePage, "이미 로그인 하셨습니다.");
		}
		

		
		String email = web.getString("email");
		String userId = web.getString("user_id");
		
		logger.info("email >>>>>>>>>>>>>>>>" + email);
		logger.info("userId >>>>>>>>>>>>>>>>" + userId);
		

		
	//임시 비밀번호 생성하기 
		String newPassword = util.getRandomPassword();
		
		MemberVo member = new MemberVo();
		member.setUserEmail(email);
		member.setUserId(userId);
		member.setUserPw(newPassword);
	
	
		//service를 통한 비밀번호 갱신하기
		try {
			memberService.updateMemberPasswordByEmail(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//발급된 비밀번호를 메일로 발송하기
		String sender = "sooblair84@gmail.com";
		String subject = "Hiceleb 비밀번호 변경 안내";
		String content = "회원님의 새로운비밀번호는 <strong>" + newPassword +  "</strong> 입니다";
		
		
		try {
			mail.sendMail(sender, email, subject, content);
		} catch (MessagingException e) {
			web.redirect(null,"메일 발송에 실패 했습니다");
			e.printStackTrace();
		}
		
		//결과 페이지로 이동
		//여기서는 이전 페이지로 이동함
		web.redirect(null,"새로운 비밀번호가 메일로 발송되었습니다");
		
		
		
	}
	
	
}
