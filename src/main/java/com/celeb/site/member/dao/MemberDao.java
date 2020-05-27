
package com.celeb.site.member.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.celeb.site.common.sqlSessionDaoSupport.CommonSqlSessionDaoSupport;
import com.celeb.site.member.vo.MemberVo;

@Repository("MemberDao")
public class MemberDao extends CommonSqlSessionDaoSupport {

	@Autowired
	MemberVo member ;

 private Logger logger = LoggerFactory.getLogger(MemberDao.class);

	 /**
	  *
	  * @return
	  * @throws Exception
	  */
	public int selectUserIdCount(MemberVo member) throws Exception {
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + member.toString());
		return getSqlSession().selectOne("MemberMapper.selectUserIdCount", member);
	}


	public int selectEmailCount(MemberVo member) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + member.toString());
		return getSqlSession().selectOne("MemberMapper.selectEmailCount", member);
	}


	public  int insertMember(MemberVo member) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + member.toString());
		return getSqlSession().insert("MemberMapper.insertMember", member);
	}
	
	public  MemberVo selectLoginInfo(MemberVo member) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + member.toString());
		return getSqlSession().selectOne("MemberMapper.selectLoginInfo", member);
	}
	
	public MemberVo findId(MemberVo member) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + member.toString());
		return getSqlSession().selectOne("MemberMapper.findId", member);
	}
	
	public  int updateMemberPasswordByEmail(MemberVo member) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + member.toString());
		return getSqlSession().update("MemberMapper.updatePasswordByEmail", member);
	}
	
	public int updateMember(MemberVo member) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + member.toString());
		return getSqlSession().update("MemberMapper.updateMember", member);
	}
	
	public  MemberVo selectMember(MemberVo member) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + member.toString());
		return getSqlSession().selectOne("MemberMapper.selectMember", member);
		
	}
	
	public int selectMemberPw(MemberVo member) throws Exception{
		System.out.println("Dao_Loogger>>>>>>>>" + member.toString());
		return getSqlSession().selectOne("MemberMapper.selectMemberPw", member);
	}
	
	
	public int deleteMember(MemberVo member) throws Exception{
		System.out.println("DAO_logger>>>>>>>>>>>>>>>" + member.toString());
		return getSqlSession().delete("MemberMapper.deleteMember", member);
	}

}