<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp" %> 
    <!-- login CSS-->
    <link href="${pageContext.request.contextPath}/resources/assets/css/login.css" rel="stylesheet" />

    <div class="background">
        <div class="container">
            <div class="ment">
                <h3>하이셀럽로그인</h3>
                <h4>하이셀럽에 오신것을 환영합니다.</h4>
            </div>
            <div class="login_box">

                <form action="${pageContext.request.contextPath}/login_ok.do" method="POST" role="form" class="loginbox">


                    <div class="form-group">

                        <input type="text" class="form-control" name="user_id" id="user_id" placeholder="아이디">

                    </div>

                    <div class="form-group">

                        <input type="password" class="form-control" name="user_pw" id="user_pw" placeholder="비밀번호">

                    </div>

				<a href="${pageContext.request.contextPath}/findId.do" class="findId">아이디찾기</a>
				<a href="${pageContext.request.contextPath}/findPw.do" class="findId">비밀번호찾기</a>
                    <button type="submit" class="btn btn-primary float-left login_btn">로그인</button>

                    <div class="checkbox auto_login">
                        <label>
                            <input type="checkbox" value="1">
                            자동로그인
                        </label>
                    </div>

                </form>

            </div>

        </div>
    </div>

  <%@ include file="/WEB-INF/views/includes/footer.jsp"%>