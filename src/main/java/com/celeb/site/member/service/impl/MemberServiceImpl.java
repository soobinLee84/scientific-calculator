package com.celeb.site.member.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celeb.site.common.util.WebHelper;
import com.celeb.site.member.dao.MemberDao;
import com.celeb.site.member.service.MemberService;
import com.celeb.site.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao mdo;

	@Autowired
	WebHelper web;

	private Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Override
	public void selectUserIdCount(MemberVo member) throws Exception {

		try {
			int result = mdo.selectUserIdCount(member);
			if (result > 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("이미 사용중인 아이디 입니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("아이디 중복검사에 실패했습니다.");
		}

	}

	@Override
	public void selectEmailCount(MemberVo member) throws Exception {

		try {
			int result = mdo.selectEmailCount(member);
			if (result > 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {

			throw new Exception("이미 사용중인 이메일 입니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("이메일 중복검사에 실패했습니다.");
		}

	}

	@Override
	public void insertMember(MemberVo member) throws Exception {

		// 아이디 중복검사 및 이메일 중복검사 호출
		selectUserIdCount(member);
		selectEmailCount(member);

		// 데이터 저장 처리 = 가입
		// not null 로 설정된 값이 설정되지 않았다면 예외 발생됨

		try {
			int result = mdo.insertMember(member);
			if (result == 0) {
				throw new NullPointerException();

			}

		} catch (NullPointerException e) {
			throw new Exception("저장된 회원정보가 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("회원가입에 실패했습니다.");
		}

	}

	@Override
	public MemberVo selectLoginInfo(MemberVo member) throws Exception {

		MemberVo result = mdo.selectLoginInfo(member);

		try {
			/**
			 * 조회된 데이터가 없다는 것은 WHERE 절을 조건에 맞는 데이터가 없다는것. --> WHERE절은 아이디와 비밀번호가 일치하는 항목을
			 * 지정하므로, 조회된 데이터가 없다는것은 아이디나 비밀번호가 잘못되었음을 의미한다.
			 */
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("아이디나 비밀번호가 잘못되었습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("로그인에 실패 했습니다.");
		}
		// 왜 데드코드인 것인가.
		return result;
	}

	@Override
	public MemberVo findId(MemberVo member) throws Exception {

		MemberVo result = null;

		try {
			result = mdo.findId(member);

		} catch (NullPointerException e) {
			throw new Exception("존재하는 이메일이 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("아이디 찾기에 실패했습니다.");
		}

		return result;
	}

	@Override
	public void updateMemberPasswordByEmail(MemberVo member) throws Exception {
		int result = 0;

		result = mdo.updateMemberPasswordByEmail(member);

		try {

			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("존재하는 회원이 없습니다.");
		}
	}

	@Override
	public void updateMember(MemberVo member) throws Exception {
		int result = 0;
		result = mdo.updateMember(member);
		
		try {
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			throw new Exception("변경된 회원 정보가 없습니다.");
		}
		
	}

	@Override
	public MemberVo selectMember(MemberVo member) throws Exception {
		//유저조회
		MemberVo result = null;
		try {
		result = mdo.selectMember(member);
		if(result == null) {
			throw new NullPointerException();
		}
		}catch(NullPointerException e) {
			throw new Exception ("조회된 회원정보가 없습니다.");
		}
		return result;
	}

	@Override
	public void selectMemberPasswordCount(MemberVo member) throws Exception {
		// 비밀번호 갯수를 카운트한다 - 회원수정용
		
	}

	@Override
	public void deleteMember(MemberVo member) throws Exception {
		// 회원탈퇴 
		try {
		int result = mdo.deleteMember(member);
		if( result == 0) {
			throw new NullPointerException();
		}
		} catch(NullPointerException e) {
			throw new Exception ("조회된 회원정보가 없습니다.");
		}
		
	}

	@Override
	public int selectMemberPw(MemberVo member) throws Exception {
		// 로그인된 아이디의 암호화된 비밀번호 조회
		int result = 0;
		
		try {
			 result = mdo.selectMemberPw(member);
			
			if(result == 0) {
				
				throw new NullPointerException();
				
			}
			}catch(NullPointerException e) {
				throw new Exception ("잘못된 비밀번호 입니다.");
			}catch(Exception e) {
				logger.error(e.getLocalizedMessage());
				throw new Exception("비밀번호 검사에 실패했습니다.");
			}
		
		return result;

	}
	
	
	
}