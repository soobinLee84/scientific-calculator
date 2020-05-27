package com.celeb.site.member.controller;

import java.util.List;
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

import com.celeb.site.common.util.RegexHelper;
import com.celeb.site.common.util.WebHelper;
import com.celeb.site.member.service.MemberService;
import com.celeb.site.member.vo.MemberVo;


/**
 * Handles requests for the application home page.
 */
@Controller
public class JoinController {

	/* (1) 사용하고자 하는 Helper + Service 객체 선언 */
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

	@Autowired
	WebHelper web;

	@Autowired
	RegexHelper regex;

	@Autowired
	MemberService memberService;

	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public String test(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		return "common";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		
		MemberVo loginInfo = (MemberVo)web.getSession("loginInfo");
		if(loginInfo != null) {
			String movePage = web.getRootPath() + "/main.do";
			web.redirect(movePage, "이미 로그인 하셨습니다.");
			return null;
		}
		return "celebJoin";
	}

	@RequestMapping(value = "/join_ok.do", method = RequestMethod.POST)
	public String join_ok(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		/* (1) 파일이 포함된 POST파라미터 받기 */
		// 뷰에서 넘어오는 파라미터
		String name = web.getString("user_name");
		String user_id = web.getString("user_id");
		String user_pw = web.getString("user_pw");
		String user_pw_re = web.getString("user_pw_re");
		String user_email = web.getString("user_email");
		String tel = web.getString("tel");
		int postcode = web.getInt("postcode");
		String addr1 = web.getString("addr1");
		String addr2 = web.getString("addr2");
		String addr3 = web.getString("addr3");
		
		logger.debug("name = " + name);
		logger.debug("user_id = " + user_id);
		logger.debug("user_pw = " + user_pw);
		logger.debug("user_pw_re = " + user_pw_re);
		logger.debug("user_email = " + user_email);

		/* (2) 입력된 값의 유효성 검사 */
		// 파라미터 순서대로 나열
		// 이름 검사
		if (!regex.isValue(name)) {
			web.redirect(null, "이름을 입력하세요");
			return null;
		}

		if (!regex.isKor(name)) {
			web.redirect(null, "이름은 한글만 입력가능합니다.");
			return null;
		}

		if (name.length() < 2 || name.length() > 20) {
			web.redirect(null, "이름은 2~20글자 까지만 가능합니다.");
			return null;
		}

		// 아이디 검사
		if (!regex.isValue(user_id)) {
			web.redirect(null, "아이디를 입력하세요");
			return null;
		}

		if (!regex.isEngNum(user_id)) {
			web.redirect(null, "아이디는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
			return null;
		}

		if (user_id.length() > 20) {
			web.redirect(null, "아이디는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
			return null;
		}

		// 비밀번호검사

		if (!regex.isValue(user_pw)) {
			web.redirect(null, "비밀번호를 입력하세요");
			return null;
		}

		if (!regex.isEngNum(user_pw)) {
			web.redirect(null, "비밀번호는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
			return null;
		}

		if (user_pw.length() > 20) {
			web.redirect(null, "비밀번호는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
			return null;
		}
		// 비밀번호와 재 입력한 비밀번호가 맞는지 확인
		if (!user_pw.equals(user_pw_re)) {
			web.redirect(null, "비밀번호 확인이 잘못되었습니다.");
			return null;
		}

		// 이메일 검사

		if (!regex.isValue(user_email)) {
			web.redirect(null, "이메일를 입력하세요");
			return null;
		}

		if (!regex.isEmail(user_email)) {
			web.redirect(null, "이메일의 형식이 잘못되었습니다.");
			return null;
		}

		/* (3) 전달받은 파라미터 Beans 객체에 담는다. */
		MemberVo member = new MemberVo();
		member.setUserName(name);
		member.setUserId(user_id);
		member.setUserPw(user_pw);
		member.setUserEmail(user_email);
		member.setPostCode(postcode);
		member.setAddr1(addr1);
		member.setAddr2(addr2);
		member.setAddr3(addr3);
		member.setTel(tel);
		
		/* (4) Service를 통한 데이터베이스 저장 처리 */
		try {
			memberService.insertMember(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			// 예외가 발생한 경우이므로 , 더이상 진행하지 않는다.
			return null;
		}

		/* (5) 가입이 완료되었으므로 메인페이지로 이동 */
		web.redirect(web.getRootPath() + "/main.do", "회원가입이 완료되었습니다.로그인 해 주세요");
		/*
		 * INSERT, UPDATE,DELETE 처리를 수행하는 action 페이지들은 자체적으로 view 를 갖지 않고 결과를 확인할 수 있는
		 * 다른 페이지로 강제 이동시켜야한다. (중복실행 방지) 그러므로 view의 경로를 리턴하지 않는다.
		 */

		return null;
	}
}