<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp"%>
<!-- Inquiries CSS-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/Inquiries.css" />
<!-- Bootstrap CSS-->
<link rel="stylesheet"
	href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">

<div class="mainBanner">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_01.jpg"
		usemap="#map01" />
	<map name="map01" id="map01">
		<area shape="rect" coords="1051,386,1287,436"
			href="${pageContext.request.contextPath}/join.do" />
	</map>
</div>
<div class="explain">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_02.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_03.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_04.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_05.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_06.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_07.png">
</div>

<div class="explain_2">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_08.png">
</div>

<div class="explain">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_09.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_10.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_11.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_12.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_13.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_14.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_15.png">
	<img
		src="${pageContext.request.contextPath}/resources/assets/img/m04_02_16.png" usemap="#map02" >

	<map name="map02" id="map02">
		<area shape="rect" coords="602,285,939,357"
			href="https://hiceleb.co.kr/upload/하이셀럽_입점문의.pdf" target="_blank" />
			<area shape="rect" coords="975,282,1313,357"
			href="${pageContext.request.contextPath}/join.do" />
	</map>
	
</div>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>