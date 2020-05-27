package com.celeb.site.member.service;




import java.util.List;

import com.celeb.site.member.vo.MemberVo;


public interface MemberService {

	
	/**
	 * 아이디 중복검사
	 * @param member - 아이디
	 * @throws Exception - 중복된 데이터인 경우 예외 발생함
	 */
	public void selectUserIdCount(MemberVo member) throws Exception;
	
	
	/**
	 * 이메일 중복검사
	 * @param member - 이메일
	 * @throws Exception - 중복된 데이터인 경우 예외 발생함
	 */
	public void selectEmailCount(MemberVo member) throws Exception;
	
	
	/**
	 * 회원가입 (아이디, 이메일 중복검사 후 가입 처리)
	 * @param member - 일련번호, 가입일시, 변경일시 제외한 모든 정보
	 * @throws Exception
	 */
	public void insertMember(MemberVo member) throws Exception;
	
	
	/**
	 * 로그인
	 * @param member - 아이디 비밀번호
	 * @return 회원정보
	 * @throws Exception
	 */
	public MemberVo selectLoginInfo(MemberVo member) throws Exception;
	
	/**
	 * 아이디찾기
	 * 가입된 이메일로 아이디 전송
	 * @param member - 이메일
	 * @return 
	 * @throws Exception
	 */
	public MemberVo findId(MemberVo member) throws Exception;
	
	/**
	 * 비밀번호찾기
	 * 가입된 이메일로 비밀번호 전송
	 * @param member - 아이디 , 이메일
	 * @return 
	 * @throws Exception
	 */
	public void updateMemberPasswordByEmail(MemberVo member) throws Exception;
	
	/**
	 * 회원정보 수정
	 * @param member
	 * @throws Exception
	 */
	public void updateMember(MemberVo member) throws Exception;
	
	/**
	 * 일련번호에 의한 회원정보 조회
	 * @param member
	 * @return MemberVo - 일련번호로 찾은 회원정보 리턴
	 * @throws Exception
	 */
	public MemberVo selectMember(MemberVo member) throws Exception;
	
	/**
	 * 회원에 관한 비밀번호 카운트
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public void selectMemberPasswordCount(MemberVo member) throws Exception;
	
	/**
	 * 회원 탈퇴
	 * @param member
	 * @throws Exception
	 */
	public void deleteMember(MemberVo member) throws Exception;
	
	/**
	 * 가입된 아이디의 비밀번호 조회
	 * @param member
	 * @return - 로그인된 아이디의  암호화된 비밀번호를 리턴한다
	 * @throws Exception
	 */
	
	public int selectMemberPw(MemberVo member) throws Exception;
}
