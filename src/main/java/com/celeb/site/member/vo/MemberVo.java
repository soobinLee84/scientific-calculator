package com.celeb.site.member.vo;

import org.springframework.stereotype.Repository;

@Repository("MemberVo")
public class MemberVo {

	private int userIdx;
	private String userId;
	private String userPw;
	private String newUserPw;
	private String userEmail;
	private String userName;
	private int postCode;
	private String addr1;
	private String addr2;
	private String addr3;
	private String regDate;
	private String editDate;
	private String tel;
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getNewUserPw() {
		return newUserPw;
	}
	public void setNewUserPw(String newUserPw) {
		this.newUserPw = newUserPw;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "MemberVo [userIdx=" + userIdx + ", userId=" + userId + ", userPw=" + userPw + ", newUserPw=" + newUserPw
				+ ", userEmail=" + userEmail + ", userName=" + userName + ", postCode=" + postCode + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", addr3=" + addr3 + ", regDate=" + regDate + ", editDate=" + editDate + ", tel="
				+ tel + "]";
	}
	
	
	
	
	
	
	

}
