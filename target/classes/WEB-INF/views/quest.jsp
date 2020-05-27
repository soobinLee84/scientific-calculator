<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp" %>    
    <!-- quest CSS-->
    <link href="${pageContext.request.contextPath}/resources/assets/css/quest.css" rel="stylesheet" />

    <div id="mainimg">
    </div>
    <div id="quest_map">
        <img src="${pageContext.request.contextPath}/resources/assets/img/quest_grade_title_img.jpg" alt="" srcset="">
        <img src="${pageContext.request.contextPath}/resources/assets/img/quest_grade_img1.jpg" alt="" srcset="">
        <img src="${pageContext.request.contextPath}/resources/assets/img/quest_grade_reward.jpg" alt="" srcset="">

        <img src="${pageContext.request.contextPath}/resources/assets/img/quest_real_img1.png" alt="" srcset="">
        <img src="${pageContext.request.contextPath}/resources/assets/img/quest_real_reward.png" alt="" srcset="">
    </div>



  <%@ include file="/WEB-INF/views/includes/footer.jsp"%>