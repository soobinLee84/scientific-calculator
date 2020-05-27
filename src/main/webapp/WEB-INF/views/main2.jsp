<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp" %>


    <div id="carousel" class="carousel slide" data-ride="carousel">
        <div class="slider_item">
            <img src="${pageContext.request.contextPath}/resources/assets/img/w_01.jpg" alt="First slide">
        </div>
        <div class="slider_item">
            <img src="${pageContext.request.contextPath}/resources/assets/img/w_02.jpg" alt="Second slide">
        </div>
        <div class="slider_item">
            <img src="${pageContext.request.contextPath}/resources/assets/img/w_03.jpg" alt="Third slide">
        </div>
        <div class="slider_item">
            <img src="${pageContext.request.contextPath}/resources/assets/img/w_04.jpg" alt="four">
        </div>
        <div class="slider_item">
            <img src="${pageContext.request.contextPath}/resources/assets/img/w_05.jpg" alt="">
        </div>


    </div>

    <div id="contents_1">
        <div class="img_wrap_1">
            <img src="${pageContext.request.contextPath}/resources/assets/img/cont_step_content.png" />
        </div>
    </div>
    <div id="contents_2">
        <div class="img_wrap_2" style="text-align: center;">
            <img src="${pageContext.request.contextPath}/resources/assets/img/con03.jpg" />
        </div>
    </div>
    <div id="contents_3">
        <div class="img_wrap_3" style="text-align: center;">
            <img src="${pageContext.request.contextPath}/resources/assets/img/con04.jpg" />
        </div>
    </div>
    <div id="contents_4">
    </div>
    <div id="contents_5">
        <div class="img_wrap_4" style="text-align: center;">
            <img src="${pageContext.request.contextPath}/resources/assets/img/cont_satisfaction_content.jpg" />
        </div>
    </div>
    <div id="contents_6">
        <div class="img_wrap_4" style="text-align: center;">
            <img src="${pageContext.request.contextPath}/resources/assets/img/mcont_movie_content.png" />
            <img src="${pageContext.request.contextPath}/resources/assets/img/step_info.jpg" />
        </div>
    </div>
    <div id="contents_7">
        <div class="img_wrap_5" style="text-align: center;">
            <img src="${pageContext.request.contextPath}/resources/assets/img/cont_uReview_content.png" />
        </div>
        <div class="mini_carousel">
            <div id="slide" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <!-- 슬라이드 쇼 -->
                    <div class="wrap_gray">
                        <div class="carousel-item active">
                            <!--가로--> <img class="d-block w-40" src="${pageContext.request.contextPath}/resources/assets/img/mini_slide_1.png" alt="First slide">

                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-40" src="${pageContext.request.contextPath}/resources/assets/img/mini_slide_2.png" alt="Second slide">
                        </div>
                        <div class="carousel-item"> <img class="d-block w-40" src="${pageContext.request.contextPath}/resources/assets/img/mini_slide_3.png"
                                alt="Third slide">
                        </div> <!-- / 슬라이드 쇼 끝 -->

                        <!-- 왼쪽 오른쪽 화살표 버튼 --> <a class="carousel-control-prev" href="#slide" data-slide="prev"> <span
                                class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <!-- <span>Previous</span> -->
                        </a> <a class="carousel-control-next" href="#slide" data-slide="next"> <span
                                class="carousel-control-next-icon" aria-hidden="true"></span> <!-- <span>Next</span> -->
                        </a> <!-- / 화살표 버튼 끝 -->
                        <!-- 인디케이터 -->
                        <ul class="carousel-indicators">
                            <li data-target="#slide" data-slide-to="0" class="active"></li>
                            <!--0번부터시작-->
                            <li data-target="#slide" data-slide-to="1"></li>
                            <li data-target="#slide" data-slide-to="2"></li>
                        </ul> <!-- 인디케이터 끝 -->
                    </div>
                    <!--wrap gray-->
                </div>
                <!--slide 끝-->
            </div>
        </div>
        <div class="contents_8">

        </div>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>