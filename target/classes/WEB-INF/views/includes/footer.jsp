<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page trimDirectiveWhitespaces="true"%>
<div id="footer">
            <div class="contents">
                <div class="footer_list at-container">
                    <div class="contents_2">
                        <ul class="pull-left">
                            <li><a href="#">이용약관</a></li>
                            <li>/</li>
                            <li><a href="#">개인정보처리방침</a></li>
                            <li>/</li>
                            <li><a href="#">입점문의</a></li>
                        </ul>
                    </div>
                </div>
                <!--at-container end-->
            </div>
            <div class="footer_bottom">
                <img src="${pageContext.request.contextPath}/resources/assets/img/footer-custom.jpg" alt="custom">
                <div class="custom_call">1899-9413</div>
                <div class="custom_detail">
                    E-mail, hi@celeb.co.kr<br />
                    AM 09:00 ~ PM 06:00
                </div>
                <div class="clearfix"></div>
                <div class="float-right footer_button">
                    <button class="celeb_open"><a href="${pageContext.request.contextPath}/join.do">셀럽몰 오픈</a></button><br />
                    <button class="celeb_question"><a href="${pageContext.request.contextPath}/customerCenter.do">1:1 문의</a></button>

                </div>
            </div>
        </div>
        <!-- slider Js-->

        <script>

            $(document).ready(function () {
                var jbOffset = $('#menu').offset();
                $(window).scroll(function () {
                    if ($(document).scrollTop() >= jbOffset.top) {
                        $('#menu').addClass('jbFixed');
                    }
                    else {
                        $('#menu').removeClass('jbFixed');
                    }
                });
            });
        </script>

</body>
</html>