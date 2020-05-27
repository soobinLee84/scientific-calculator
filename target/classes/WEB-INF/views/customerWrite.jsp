<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp"%>
<link href="${pageContext.request.contextPath}/resources/assets/css/customerwrite.css" rel="stylesheet" />
<div class="container">
	<div class="content">
		<div class="form-group">
		<div class="ment">
			<h4>안녕하세요 문의 게시판입니다.</h4>
			<p>궁금하신 사항이나 문의사항이 있으시면 편히 남겨주세요!</p>
			</div>

			<form action="${pageContext.request.contextPath}/customerWriteOk.do"
				method="POST" class="form-horizontal" role="form">
				<input type="hidden" name="boardIdx" id="boardIdx" class="boardIdx"/>
				<textarea class="title" name="title" id="title" cols="130" rows="1"></textarea>
				<textarea name="board" id="board" cols="130" rows="20"></textarea>
				
				<div class="col-sm-10 col-sm-offset-2 btngroup">
					<a href="${pageContext.request.contextPath}/customerCenter.do">
					<button class="btn btn-info">목록</button></a>
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
				<!--btngroup end-->
			</form>
		</div>
		<!--form-group end-->

	</div>
	<!--content end-->
</div>
<!--container end-->


<%@ include file="/WEB-INF/views/includes/footer.jsp"%>