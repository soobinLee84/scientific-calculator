<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp"%>


<!-- customer CSS-->
<link
	href="${pageContext.request.contextPath}/resources/assets/css/customer_center.css"
	rel="stylesheet" />

<div class="customer_center">
	<h3 class="customer_ment">고객센터</h3>
	<div class="tab_content">
		<div class="tab_menu">
			<input type="radio" name="tabmenu" id="tab01" checked> <label
				for="tab01">문의게시판</label> <input type="radio" name="tabmenu"
				id="tab02"> <label for="tab02">이벤트&혜택</label>
				<input type="radio" name="tabmenu" id="tab03" onclick="location.href = '${pageContext.request.contextPath}/inquiries.do'" >
				<label for="tab03" >입점문의
				
				</label>
			<button class="writeBoard btn btn-link">
				<a href="${pageContext.request.contextPath}/customerWrite.do">글쓰기</a>
			</button>
			<!-- 9 -->
			<div class="conbox con1">
				<table class="table"
					style="margin-top: 33px; background-color: white;">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>날짜</th>
							<th>조회수</th>
						</tr>
					</thead>

					<tbody>
						<c:choose>
							<c:when test="${fn:length(boardList) >0 }">
								<c:forEach var="board" items="${boardList}" varStatus="s">
									<c:if test="${board.boardIdx != null }">
										
											<span class="detail_span">
										<tr>
											<td>${totalCount - s.index - pageHelper.limitStart}</td>
											<td><a style="text-decoration:none; color:black;"href="${pageContext.request.contextPath}/detail.do?boardIdx=${board.boardIdx}">${board.title}</a></td>
											<td>${board.userId }</td>
											<td>${board.regDate.substring(0, 10)}</td>
											<td><c:out value="${board.count}" /></td>
											
										</tr>
										</span>
										

									</c:if>
								</c:forEach>
							</c:when>
						</c:choose>

					</tbody>
				</table>
				<!-- Paging 처리, Bootstrap -->
	<div class="paging">
		<nav class="text-center">
			<ul class="list-unstyled pagination">

				<c:choose>

					<c:when test="${pageHelper.prevPage > 0}">
						<!-- 첫 페이지로 가는 url  -->
						<c:url var="firstUrl" value="/customerCenter.do">
							<c:param name="pagehelper" value="1" />
						</c:url>
						<!-- 이전페이지로 가는 url -->
						<c:url var="prevUrl" value="/customerCenter.do">
							<c:param name="page" value="${pageHelper.prevPage}" />
						</c:url>

						<li><a href="${firstUrl}">&laquo;</a></li><!-- &laquo; : 왼쪽 꺽인 괄호  -->
						<li><a href="${prevUrl}">&lt;</a></li><!--  오른쪽이 꺽인 괄호  -->
					</c:when>

					<c:otherwise>
						<li class="disabled"><a href="#">&laquo;</a></li>
						<li class="disabled"><a href="#">&lt;</a></li>
					</c:otherwise>
				</c:choose>
	<!-- 현재 그룹의 시작번호 -->
				<c:forEach var="i" begin="${pageHelper.startPage}"
					end="${pageHelper.endPage}">
					<c:url var="pageUrl" value="/customerCenter.do">
						<c:param name="page" value="${i}" />
					</c:url>

					<c:choose>
						<c:when test="${pageHelper.page == i}">
							<li class="active"><a href="#">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:choose>
					<c:when test="${pageHelper.nextPage > 0}">
						<c:url var="lastUrl" value="/customerCenter.do">
							<c:param name="page" value="${pageHelper.totalPage}" />
						</c:url>
						<c:url var="nextUrl" value="/customerCenter.do">
							<c:param name="page" value="${pageHelper.nextPage}" />
						</c:url>
						<li><a href="${nextUrl}">&gt;</a></li>
						<li><a href="${lastUrl}">&raquo;</a></li>
					</c:when>

					<c:otherwise>
						<li class=""><a href="#">&gt;</a></li>
						<li class=""><a href="#">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>
	
	<!-- Paiging 처리 end-->
			</div>
			<div class="conbox con2"></div>
			<div class="conbox con3"></div>
		</div>

	</div>

	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>