package com.celeb.site.comment.vo;

import org.springframework.stereotype.Repository;

@Repository("CommentVo")
public class CommentVo {
	private int commentIdx;
	private String userId;
	private String content;
	private String regDate;
	private String ipAddress;
	private int boardIdx;
	private int userIdx;
	private int LimitStart;
	private int ListCount;
	public int getCommentIdx() {
		return commentIdx;
	}
	public void setCommentIdx(int commentIdx) {
		this.commentIdx = commentIdx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public int getLimitStart() {
		return LimitStart;
	}
	public void setLimitStart(int limitStart) {
		LimitStart = limitStart;
	}
	public int getListCount() {
		return ListCount;
	}
	public void setListCount(int listCount) {
		ListCount = listCount;
	}
	@Override
	public String toString() {
		return "CommentVo [commentIdx=" + commentIdx + ", userId=" + userId + ", content=" + content + ", regDate="
				+ regDate + ", ipAddress=" + ipAddress + ", boardIdx=" + boardIdx + ", userIdx=" + userIdx
				+ ", LimitStart=" + LimitStart + ", ListCount=" + ListCount + "]";
	}
	
	
}
