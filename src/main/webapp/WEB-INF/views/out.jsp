<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/out.css" />

<div class="wrap">
        <div class="findIdMent">
            <h3>탈퇴하기</h3>
            <h5>회원 탈퇴하는 페이지 입니다.</h5>

        </div>

        <form action="outOk.do" class="emailForm" method="POST" role="form">
            <legend>비밀번호</legend>

            <div class="form-group">
                <label for="password">*로그인시 입력한 비밀번호를 기입 해 주세요</label>
                <input type="password" class="form-control" name="user_pw" id="user_pw">
            </div>

          

            <div class="notAuto">
                <p>*자동입력 방지입니다.</p>
                  <select class="form-group col-sm-12 outSelection" style="height:35px;" name="outSelection" id="outSelection">
                <option>---------------------------------------- 탈퇴사유를 선택 해 주세요
                    ----------------------------------------</option>
                
                <option value="1">사이트의 컨텐츠 부족</option>
                <option value="2">사이트 내의 오류및 버그가 많아서</option>
                <option value="3">서비스가 불친절 해서</option>
                <option value="4">타 사이트 대비 마케팅이 부족해서</option>
                <option value="5">기타</option>
            </select>
            </div>
            <button type="submit" class="btn btn-primary">탈퇴하기</button>
        </form>

    </div>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
