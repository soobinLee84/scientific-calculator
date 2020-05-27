<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>
<div id="menu">
        <nav id="topMenu">
            <ul>
                <li class="home">
                    <a href="${pageContext.request.contextPath}/main.do" >
                        <img src="https://hiceleb.co.kr/img/new_logo.jpg"  style="top:18px">
                    </a>
                </li>
                <c:choose>
                <c:when test = "${loginInfo == null }">
                <!-- 로그인 안 된경우 -->
                <li class="login float-right">
                    <a href="${pageContext.request.contextPath}/login.do" style="text-decoration: none; color: dimgrey;">
                    <img src="${pageContext.request.contextPath}/resources/assets/img/new_icon1.jpg" style="padding-right: 10px;" />로그인</a>
                </li>
                <li class="join float-right">
                    <a class="joinSpec" href="${pageContext.request.contextPath}/join.do" style=" text-decoration: none; color: dimgrey; "><img
                            src="${pageContext.request.contextPath}/resources/assets/img/new_icon2.jpg" style="padding-right: 10px;" />회원가입</a>
                </li>
                </c:when>
                <c:otherwise>
                <!-- 로그인 된 경우 -->
            	
                <a href="${pageContext.request.contextPath}/logout.do" class="float-right" style="font-size:14px; text-decoration:none; color:dimgrey; padding-top:2px; padding-right: 20px;">로그아웃</a>
                <span class="float-right" style="color:#191919; opacity:0.7; margin-right:16px;"><a href="${pageContext.request.contextPath}/edit.do">${loginInfo.userId}님 </a></span>
                </c:otherwise>
                </c:choose>
                <li class="topMenuLi"> <a class="menuLink" href="./guide.html">서비스 가이드</a>
                    <ul class="submenu">
                        <li><a href="${pageContext.request.contextPath}/quest.do" class="submenuLink longLink">초보자 퀘스트</a></li>
                        <li><a href="#" class="submenuLink longLink">|</a></li>
                        <li><a href="${pageContext.request.contextPath}/guide.do" class="submenuLink longLink">셀럽 가이드</a></li>
                    </ul>
                </li>
                <!--서비스 가이드 end-->

                <li class="topMenuLi"> <a class="menuLink" href="#">셀럽몰 오픈</a>
                    <ul class="submenu">
                        <li><a href="${pageContext.request.contextPath}/join.do" class="submenuLink longLink">셀럽몰 오픈</a></li>
                        <li><a href="#" class="submenuLink longLink">|</a></li>
                        <li><a href="${pageContext.request.contextPath}/forsale.do" class="submenuLink longLink">판매 가능 상품</a></li>
                    </ul>
                </li>

                <li class="topMenuLi"> <a class="menuLink" href="#">고객센터</a>
                    <ul class="submenu">
                        <li><a href="${pageContext.request.contextPath}/customerCenter.do" class="submenuLink longLink">문의사항</a></li>
                        <li><a href="#" class="submenuLink longLink">|</a></li>
                        <li><a href="#" class="submenuLink longLink">이벤트 & 혜택</a></li>
                        <li><a href="#" class="submenuLink longLink">|</a></li>
                        <li><a href="${pageContext.request.contextPath}/inquiries.do" class="submenuLink longLink">입점문의</a></li>
                    </ul>
                </li>

            </ul>
        </nav>

    </div>