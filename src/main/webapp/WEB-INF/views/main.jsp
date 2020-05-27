<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp"%>


<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
		<li data-target="#myCarousel" data-slide-to="4"></li>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img src="${pageContext.request.contextPath}/resources/assets/img/w_01.jpg" usemap="#map01">
			<map name="map01" id="map01">
			<area shape="rect" coords="1123,551,1318,597" href="${pageContext.request.contextPath}/join.do" />
			</map>
		</div>

		<div class="item">
			<img src="${pageContext.request.contextPath}/resources/assets/img/w_02.jpg" usemap="#map02">
			<map name="map02" id="map02">
			<area shape="rect" coords="403,569,604,618" href="${pageContext.request.contextPath}/join.do" />
			</map>
		</div>

		<div class="item">
			<img src="${pageContext.request.contextPath}/resources/assets/img/w_03.jpg" usemap="#map03">
			<map name="map03" id="map03">
			<area shape="rect" coords="1074,564,1267,609" href="${pageContext.request.contextPath}/join.do" />
			</map>
		</div>

		<div class="item">
			<img src="${pageContext.request.contextPath}/resources/assets/img/w_04.jpg" usemap="#map04">
			<map name="map04" id="map04">
			<area shape="rect" coords="297,581,486,630" href="${pageContext.request.contextPath}/join.do" />
			</map>
		</div>
		
		<div class="item">
			<img src="${pageContext.request.contextPath}/resources/assets/img/w_05.jpg" usemap="#map05">
			<map name="map05" id="map05">
			<area shape="rect" coords="1210,552,1401,598" href="${pageContext.request.contextPath}/join.do" />
			</map>
		</div>
	</div>

	<!-- Left and right controls -->
	<a class="left carousel-control" href="#myCarousel" role="button"
		data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
		aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" role="button"
		data-slide="next"> <span class="glyphicon glyphicon-chevron-right"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
</div>

<div id="contents_1">
	<div class="img_wrap_1">
		<img
			src="${pageContext.request.contextPath}/resources/assets/img/cont_step_content.png" />
	</div>
</div>
<div id="contents_2">
	<div class="img_wrap_2" style="text-align: center;">
		<img
			src="${pageContext.request.contextPath}/resources/assets/img/con03.jpg" />
	</div>
</div>
<div id="contents_3">
	<div class="img_wrap_3" style="text-align: center;">
		<img
			src="${pageContext.request.contextPath}/resources/assets/img/con04.jpg" usemap="#map07" />
				<map name="map07" id="map07">
			<area shape="rect" coords="670,387,1022,476" href="${pageContext.request.contextPath}/forsale.do" />
			</map>
	</div>
</div>
<div id="contents_4"></div>
<div id="contents_5">
	<div class="img_wrap_4" style="text-align: center;">
		<img
			src="${pageContext.request.contextPath}/resources/assets/img/cont_satisfaction_content.jpg" />
	</div>
</div>
<div id="contents_6">
	<div class="img_wrap_4" style="text-align: center;">
		<img
			src="${pageContext.request.contextPath}/resources/assets/img/mcont_movie_content.png" />
		<img
			src="${pageContext.request.contextPath}/resources/assets/img/step_info.jpg"  />
<!-- 			<iframe id="youtube_video" class="youtube_video" width="100%" height="670" src="https://www.youtube.com/embed/JUdbzQx4k08?&amp;html5-1&amp;enablejsapi=1&amp;autoplay=0&amp;loop=1&amp;controls=2&amp;disablekb=1&amp;enablejsapi=1&amp;fs=1&amp;modestbranding=1&amp;rel=0&amp;showinfo=0&amp;vq=hd1080;" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen=""></iframe> -->
	</div>
</div>
<div id="contents_7">
	<div class="img_wrap_5" style="text-align: center;">
		<img
			src="${pageContext.request.contextPath}/resources/assets/img/cont_uReview_content.png" />
	</div>
	


	
	
	<div class="mini_carousel">
		<div id="slide" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
				<!-- 슬라이드 쇼 -->
				<div class="wrap_gray">
					<div class="carousel-item active">
						<!--가로-->
						<img class="d-block w-40"
							src="${pageContext.request.contextPath}/resources/assets/img/mini_slide_1.png"
							alt="First slide">

					</div>
					<div class="carousel-item">
						<img class="d-block w-40"
							src="${pageContext.request.contextPath}/resources/assets/img/mini_slide_2.png"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-40"
							src="${pageContext.request.contextPath}/resources/assets/img/mini_slide_3.png"
							alt="Third slide">
					</div>
					<!-- / 슬라이드 쇼 끝 -->

					<!-- 왼쪽 오른쪽 화살표 버튼 -->
					<a class="carousel-control-prev" href="#slide" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<!-- <span>Previous</span> -->
					</a> <a class="carousel-control-next" href="#slide" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<!-- <span>Next</span> -->
					</a>
					<!-- / 화살표 버튼 끝 -->
					<!-- 인디케이터 -->
					<ul class="carousel-indicators">
						<li data-target="#slide" data-slide-to="0" class="active"></li>
						<!--0번부터시작-->
						<li data-target="#slide" data-slide-to="1"></li>
						<li data-target="#slide" data-slide-to="2"></li>
					</ul>
					<!-- 인디케이터 끝 -->
				</div>
				<!--wrap gray-->
			</div>
			<!--slide 끝-->
		</div>
	</div>
	<div class="contents_8"></div>
	</div>
	
	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>