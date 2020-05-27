<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ include file="/WEB-INF/views/includes/header.jsp" %>
  
    <!-- forsale CSS-->
    <link href="${pageContext.request.contextPath}/resources/assets/css/forsale.css" rel="stylesheet" />
<%@ include file="/WEB-INF/views/includes/topMenu.jsp" %>

  
    <div class="container">

        <div class="tab_content">
            <input type="radio" name="tabmenu" id="tab01" checked>
            <label for="tab01">ALL</label>
            <input type="radio" name="tabmenu" id="tab02">
            <label for="tab02">뷰티</label>
            <input type="radio" name="tabmenu" id="tab03">
            <label for="tab03">육아</label>
            <input type="radio" name="tabmenu" id="tab04">
            <label for="tab04">다이어트</label>
            <input type="radio" name="tabmenu" id="tab05">
            <label for="tab05">식품/건강</label>
            <input type="radio" name="tabmenu" id="tab06">
            <label for="tab06">디지털/가전</label>
            <input type="radio" name="tabmenu" id="tab07">
            <label for="tab07">생활</label>
            <input type="radio" name="tabmenu" id="tab08">
            <label for="tab08">주방/욕실</label>
            <input type="radio" name="tabmenu" id="tab09">
            <label for="tab09">애견</label>
            <input type="radio" name="tabmenu" id="tab10">
            <label for="tab10">패션/잡화</label>
            <input type="radio" name="tabmenu" id="tab11">
            <label for="tab11">기타</label>
            <p>
                <b>ALLPRODUCTS</b>
                <span class="dont">놓치지 않을테다! 모든 제품 한눈에 보고 픽하자!</span>
            </p>
            <div class="conbox con1">
                <div class="responsive">
                    <div class="gallery">
                        <a target="_blank" href="#">
                            <img src="${pageContext.request.contextPath}/resources/assets/product_img/thumb-64yA7ZGc2_280x295.jpg" width="300" height="200">
                        </a>
                        <div class="desc">
                            <div class="ment_wrap">
                                <span class="title">쁘띠쁘띠 라스베라트롤 앰플</span>
                                <div class="float-left cost">
                                    판매가
                                    <p>판매수익</p>
                                </div>

                                <div class="float-right only_celeb">
                                    셀럽만조회가능
                                    <p>셀럽만조회가능</p>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>


                <div class="responsive">
                    <div class="gallery">
                        <a target="_blank" href="img_forest.jpg">
                            <img src="${pageContext.request.contextPath}/resources/assets/product_img/thumb-66mU7J241_280x295.jpg" alt="Forest" width="600" height="400">
                        </a>
                        <div class="desc">
                            <div class="ment_wrap">
                                <span class="title">쁘띠쁘띠 라스베라트롤 앰플</span>
                                <div class="float-left cost">
                                    판매가
                                    <p>판매수익</p>
                                </div>

                                <div class="float-right only_celeb">
                                    셀럽만조회가능
                                    <p>셀럽만조회가능</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="responsive">
                    <div class="gallery">
                        <a target="_blank" href="img_lights.jpg">
                            <img src="${pageContext.request.contextPath}/resources/assets/product_img/thumb-67iM7J2065287J24_280x295.jpg" alt="Northern Lights"
                                width="600" height="400">
                        </a>
                        <div class="desc">
                            <div class="ment_wrap">
                                <span class="title">쁘띠쁘띠 라스베라트롤 앰플</span>
                                <div class="float-left cost">
                                    판매가
                                    <p>판매수익</p>
                                </div>

                                <div class="float-right only_celeb">
                                    셀럽만조회가능
                                    <p>셀럽만조회가능</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="responsive">
                    <div class="gallery">
                        <a target="_blank" href="img_mountains.jpg">
                            <img src="${pageContext.request.contextPath}/resources/assets/product_img/thumb-7I2464Sk7J282_280x295.jpg" alt="Mountains" width="600"
                                height="400">
                        </a>
                        <div class="desc">
                            <div class="ment_wrap">
                                <span class="title">쁘띠쁘띠 라스베라트롤 앰플</span>
                                <div class="float-left cost">
                                    판매가
                                    <p>판매수익</p>
                                </div>

                                <div class="float-right only_celeb">
                                    셀럽만조회가능
                                    <p>셀럽만조회가능</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="responsive">
                    <div class="gallery">
                        <a target="_blank" href="img_mountains.jpg">
                            <img src="${pageContext.request.contextPath}/resources/assets/product_img/thumb-7I2464Sk7J282_280x295.jpg" alt="Mountains" width="600"
                                height="400">
                        </a>
                        <div class="desc">
                            <div class="ment_wrap">
                                <span class="title">쁘띠쁘띠 라스베라트롤 앰플</span>
                                <div class="float-left cost">
                                    판매가
                                    <p>판매수익</p>
                                </div>

                                <div class="float-right only_celeb">
                                    셀럽만조회가능
                                    <p>셀럽만조회가능</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



            </div>
            <div class="conbox con2">뷰티</div>
            <div class="conbox con3">육아</div>
            <div class="conbox con4">다이어트</div>
            <div class="conbox con5">식품/건강</div>
            <div class="conbox con6">디지털/가전</div>
            <div class="conbox con7">생활</div>
            <div class="conbox con8">주방/욕실</div>
            <div class="conbox con9">애견</div>
            <div class="conbox con10">패션/잡화</div>
            <div class="conbox con11">기타</div>
        </div>




        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </div>
    <!--container end-->
      <%@ include file="/WEB-INF/views/includes/footer.jsp"%>