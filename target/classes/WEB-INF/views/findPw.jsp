<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp"%>
<link href="${pageContext.request.contextPath}/resources/assets/css/find_pw.css" rel="stylesheet" />

<div class="wrap">
        <div class="findPwMent">
            <h3>비밀번호 찾기</h3>
            <h5>비밀번호 찾기 페이지 입니다. 가입하신 이메일과 아이디를 입력 해 주세요</h5>
            <p>가입하신 이메일로 임시 비밀번호를 전송 해 드립니다.</p>
        </div>

        <form action="findPwOk.do" class="emailForm" method="POST" role="form">
            <legend>아이디</legend>

            <div class="form-group">   
                <input type="text" class="form-control" name="user_id" id="user_id" placeholder="아이디를 입력 해주세요">

            </div>
	
	<legend>이메일</legend>
	  <div class="form-group">
                <label for="ment">*전송시 최대 5분가량 소요 될 수 있습니다.</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="이메일를 입력 해주세요">
            </div>

            <p class="float-right findPw"><a href="${pageContext.request.contextPath}/findId.do">아이디 찾기</a></p>
            <button type="submit" class="btn btn-primary">전송</button>
        </form>

    </div>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
