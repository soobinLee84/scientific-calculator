package com.celeb.site.member.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

@Controller
public class EditAndDeleteController {

	/* (1) 사용하고자 하는 Helper + Service 객체 선언 */
	private static final Logger logger = LoggerFactory.getLogger(EditAndDeleteController.class);

	@Autowired
	WebHelper web;

	@Autowired
	RegexHelper regex;

	@Autowired
	MemberService memberService;

	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value = "/edit.do", method = RequestMethod.GET)
	public String editMember(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		/*(1) 로그인 여부 검사*/
		//로그인중인 회원 정보 가져오기
		MemberVo loginInfo = (MemberVo)web.getSession("loginInfo");
		
		//로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if(loginInfo == null) {
			web.redirect(web.getRootPath()+"/main.do","로그인 후에 이용 가능합니다.");
		}
		return "edit";
	}
	
	@RequestMapping(value = "/edit_ok.do", method = RequestMethod.POST)
	public String editOk(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		
		/*(1) 로그인 여부 검사*/
		//로그인중인 회원 정보 가져오기
		MemberVo loginInfo = (MemberVo)web.getSession("loginInfo");
		
		//로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if(loginInfo == null) {
			web.redirect(web.getRootPath()+"/main.do","로그인 후에 이용 가능합니다.");
		}

		String userPw = web.getString("user_pw");
		String name = web.getString("user_name");
		String newUserPw = web.getString("new_user_pw");
		String newUserPwRe = web.getString("new_user_pw_re");
		String tel = web.getString("tel");
		String postCode = web.getString("postcode");
		String addr1 = web.getString("addr1");
		String addr2 = web.getString("addr2");
		String addr3 = web.getString("addr3");
		String userEmail = web.getString("user_email");
		String userIdx = web.getString("userIdx");

		logger.debug("userPw >>> " + userPw);
		logger.debug("name >>> " + name);
		logger.debug("newUserPw >>> " + newUserPw);
		logger.debug("newUserPwRe >>> " + newUserPwRe);
		logger.debug("tel >>> " + tel);
		logger.debug("postCode >>> " + postCode);
		logger.debug("addr1 >>> " + addr1);
		logger.debug("addr2 >>> " + addr2);
		logger.debug("addr3 >>> " + addr3);
		logger.debug("userEmail >>> " + userEmail);
		logger.debug("userIdx >>> " + userIdx);
		
		//현재 비밀번호 검사
		//-> 신규 비밀번호 검사
		//신규비밀번호가 입력된경우는 변겨으로 간주하고, 입력하지않는경우는
		//	변경하지 않도록 처리한다. 그러므로 입력된 경우만 검사해야한다.
		if(regex.isValue(newUserPw)) {
			if(!regex.isEngNum(newUserPw) || newUserPw.length() > 20) {
				web.redirect(null, "새로운 비밀번호는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
				return null;
			}
		}
		//비밀번호 확인
		if(regex.isValue(newUserPwRe)) {
			if(!newUserPw.equals(newUserPwRe)) {
				web.redirect(null, "비밀번호 확인이 잘못되었습니다.");
				return null;
			}
		}
		
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

		// 이메일 검사

		if (!regex.isValue(userEmail)) {
			web.redirect(null, "이메일를 입력하세요");
			return null;
		
		}

		if (!regex.isEmail(userEmail)) {
			web.redirect(null, "이메일의 형식이 잘못되었습니다.");
			return null;
		
		}
		
		//연락처 검사
		if(!regex.isValue(tel)) {
			web.redirect(null, "연락처를 입력하세요");
			return null;
		}
		
		if(!regex.isCellPhone(tel) && !regex.isTel(tel)) {
			web.redirect(null, "연락처의 형식이 잘못되었습니다.");
			return null;
		}
		
		MemberVo member = new MemberVo();
		member.setUserIdx(Integer.parseInt(userIdx));
		member.setUserPw(userPw);
		member.setNewUserPw(newUserPw);
		member.setUserName(name);
		member.setUserEmail(userEmail);
		member.setPostCode(Integer.parseInt(postCode));
		member.setAddr1(addr1);
		member.setAddr2(addr2);
		member.setAddr3(addr3);
		member.setTel(tel);
	

		//변경된 정보를 저장하기 위한 객체
		MemberVo editInfo = null;
		
		try {
			
			memberService.updateMember(member);
			editInfo = memberService.selectMember(member);
			
		} catch (Exception e) {
			web.redirect( null, e.getLocalizedMessage());
			e.printStackTrace();
		}

		//세션 , 쿠키 갱신
		//일단 쿠키의 썸네일 정보를 삭제한다.
		web.setSession("loginInfo",editInfo);
		web.redirect("/edit.do", "수정되었습니다");
		return null;
	}
	
	@RequestMapping(value = "/out.do", method = RequestMethod.GET)
	public String out(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		
		return "out";
	}
	


	@RequestMapping(value = "/outOk.do", method = RequestMethod.POST)
	public void outOk(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		/*(1) 로그인 여부 검사*/
		//로그인중인 회원 정보 가져오기
		MemberVo loginInfo = (MemberVo)web.getSession("loginInfo");
		
		String userPw = web.getString("user_pw");
		String userId = loginInfo.getUserId();
		
		
		logger.info(">>>>>>>>>>user_pw" + userPw);
		logger.info(">>>>>>>>>>user_id" + userId);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>userPw<<<<<<<<<<<<<<<" + userPw );	
		
		
		MemberVo member = new MemberVo();
		member.setUserId(userId);
		member.setUserPw(userPw);
		

		
		try {
			//비밀번호 검사 --> 비밀번호가 잘못된 경우 예외 발생
			memberService.selectMemberPw(member);
			if(memberService.selectMemberPw(member) == 0) {
				web.redirect(null, "비밀번호가 맞지않습니다 다시한번 확인 해 주세요");
			} else {
				//탈퇴처리
				try {
					memberService.deleteMember(member);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				web.redirect(web.getRootPath()+"/main.do", "탈퇴 되었습니다. 이용 해 주셔서 감사합니다.");
				web.removeAllSession();
				
			}
		}catch(NullPointerException e) {
			web.redirect(null, e.getLocalizedMessage());
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
		}
		
		
	
	
	}
	


}
