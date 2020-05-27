<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp"%>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/tms.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>


<body>
	<div class="content_tmp">
	<div class="content_map_inner">
	<h3>택배조회 서비스입니다.</h3>
	<h4>제공받은 택배 송장번호를 기입해 주세요</h4>
	<p>*택배사 선택은 필수 입니다.</p>
	
	<span id="tekbeCompnayName">택배회사명: </span>
	<select id="tekbeCompnayList" name="tekbeCompnayList"></select>
	<br />
	<br />

	<span id="invoiceNumber">운송장번호: </span>
	<input type="text" id="invoiceNumberText" name="invoiceNumberText">
	<br />
	<br />
	<button id="myButton1">택배 조회하기</button>
	<br />
	<br />
	<div>
		<table id="myPtag"></table>
	</div>
	<br />
	<div>
		<table id="myPtag2"></table>
	</div>
	
	</div><!-- conntent_map_inner end -->
	</div><!-- content_tmp -->
	

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	<script>
		$(document)
				.ready(
						function() {
							var myKey = "l8BHv5tHHeygzvJBJDXe0Q"; // sweet tracker에서 발급받은 자신의 키 넣는다.

							// 택배사 목록 조회 company-api
							$.ajax({
										type : "GET",
										dataType : "json",
										url : "http://info.sweettracker.co.kr/api/v1/companylist?t_key="+ myKey,
										success : function(data) {

											// 방법 2. Json으로 가져온 데이터에 Array로 바로 접근하기
											var CompanyArray = data.Company; //json Array 에 접근하기위해 Array명 Company 입력
											

											var mydata = "";

											$.each(
											CompanyArray,
											//key, 와 value가 갑자기 어디서 나타났나했더니 
											//companyarray의 key 와 value 값이었다!
											function(key, value) {
																mydata += ('<option value = ' + value.Code+'>' + value.Name + '</option>');
															});
										
											$('#tekbeCompnayList').html(mydata);
										}

									});
							//배송정보와 배송 추적 tracking-api
							$("#myButton1").click(function(){
								var t_code = $("#tekbeCompnayList option:selected").val();
								var t_invoice = $('#invoiceNumberText').val();
								$.ajax({
									type:"GET",
									dataType:"json",
									url:"http://info.sweettracker.co.kr/api/v1/trackingInfo?t_key="+myKey+"&t_code="+t_code+"&t_invoice="+t_invoice,
									success: function(data){
										console.log(data);
								var myInvoiceData = "";
									if(data.status == false){
										myInvoiceData += ('<p>'+ data.msg +'</p>');
										alert(data.msg);
										alert(t_invoice);
										alert(t_code);
										}else{
										
										myInvoiceData += ('<tr>');
										myInvoiceData += ('<th>'+ "보내는사람"+'</th>');
										myInvoiceData += ('<td>'+ data.senderName 	+ '</td>');
										myInvoiceData += ('</tr>');
										myInvoiceData += ('<tr>');
										myInvoiceData += ('<th>'+ "제품정보"+'</th>');
										myInvoiceData += ('<td>'+ data.itemName 	+ '</td>');
										myInvoiceData += ('</tr>');										
										myInvoiceData += ('<tr>');
										myInvoiceData += ('<th>'+ "송장번호"+'</th>');
										myInvoiceData += ('<td>'+ data.invoiceNo 	+ '</td>');
										myInvoiceData += ('</tr>');										
										myInvoiceData += ('<tr>');
										myInvoiceData += ('<th>'+ "받는주소"+'</th>');
										myInvoiceData += ('<td>'+ data.receiverAddr+ '</td>');
										myInvoiceData += ('</tr>');										
										}
									
									$("#myPtag").html(myInvoiceData);
									
									
									
									var trackingDetails = data.trackingDetails;
									var load = "";
									var header = "";
									
// 									header += ('<tr>'+"위치"+'</tr>');
// 									header += ('<tr>'+"상황"+'</tr>');
// 									header += ('<tr>'+"시간"+'</tr>');
									
									if(trackingDetails == null){
										alert("만료된 번호이므로 상세조회가 불가능 합니다.");
									}else{
										$.each(trackingDetails , function(key,value){
											
											load += ('<tr>'+"위치"+'</tr>');
											load += ('<tr>'+"상황"+'</tr>');
											load += ('<tr>'+"시간"+'</tr>');
											load += ('<th>'+ trackingDetails[key].where + '</th>');
											load +=('<th>' + trackingDetails[key].kind + '</th>')
											load +=('<th>' + trackingDetails[key].timeString+ '</th>')
									});
										
									$("#myPtag2").html(load);
											
								}
								
							
								
								}
								
							});
						});
						});
		
		
	</script>
</body>
</html>