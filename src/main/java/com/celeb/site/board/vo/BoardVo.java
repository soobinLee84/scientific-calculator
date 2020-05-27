package com.celeb.site.board.vo;

import org.springframework.stereotype.Repository;

@Repository("boardVo")
public class BoardVo {
	private int boardIdx;
	private String title;
	private String content;
	private String userId;
	private String regDate;
	private int count;
	private int LimitStart;
	private int ListCount;
	
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
		return "BoardVo [boardIdx=" + boardIdx + ", title=" + title + ", content=" + content + ", userId=" + userId
				+ ", regDate=" + regDate + ", count=" + count + ", LimitStart=" + LimitStart + ", ListCount="
				+ ListCount + "]";
	}
	
	
	
	
}
