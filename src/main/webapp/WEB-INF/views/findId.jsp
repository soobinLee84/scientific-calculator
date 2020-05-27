<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp"%>
<link href="${pageContext.request.contextPath}/resources/assets/css/find_id.css" rel="stylesheet" />
	  <div class="wrap">
        <div class="findIdMent">
            <h3>아이디 찾기</h3>
            <h5>아이디 찾기 페이지 입니다. 가입하신 이메일을 입력 해 주세요</h5>
            <p>가입하신 아이디를 이메일로 전송 해 드립니다.</p>
        </div>

        <form action="findIdOk.do" class="emailForm" method="POST" role="form">
            <legend>이메일</legend>

            <div class="form-group">
                <label for="email">*전송시 최대 5분가량 소요 될 수 있습니다.</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="가입하신 이메일을 입력 해주세요">
            </div>


            <p class="float-right findPw"><a href="${pageContext.request.contextPath}/findPw.do">비밀번호 찾기</a></p>
            <button type="submit" class="btn btn-primary">전송</button>
        </form>

    </div>


<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
