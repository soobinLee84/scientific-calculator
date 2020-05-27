<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/topMenu.jsp"%>
<!-- celeb_mall_open CSS-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/edit.css" />
<!-- 회원정보 수정을위한 페이지 -->
<div class="wrap">
	<div class="celeb_start">
		<form action="${pageContext.request.contextPath}/edit_ok.do" method="POST" name="joinForm" id="join"
			role="form">
		<input type="hidden" name="userIdx" Id="userIdx" value="${loginInfo.userIdx}"/>
			<div class="ment">
				<h3>회원정보 수정하기</h3>
				<h4>수정할 정보를 입력 해 주세요</h4>
			</div>
			<div class="form-group">
				<label for="user_id" class="float-left" style="margin-bottom:10px;">아이디</label> 
				<div class="col-md-10">
				<p class="form-control-static" style="margin-bottom:15px;padding-bottom:10px;"><strong>${loginInfo.userId}</strong></p>
				</div>
			</div>
			
			<div class="form-group clearfix">
			
				<label for="user_pw">현재 비밀번호</label> <input type="password"
					class="form-control" id="user_pw" name="user_pw" placeholder="현재 비밀번호">
					<p class="clearfix" style="padding-left:10px;">*(영문자,숫자,_만 입력 가능합니다. 최소 3자이상 입력)</p>
			</div>
			<div class="form-group">
				<label for="new_user_pw">변경할 비밀번호</label>
				<input type="password"
					class="form-control" id="new_user_pw" name="new_user_pw"
					placeholder="변경을 원하실 경우에만 입력 해 주세요">
			</div>
			
			<div class="form-group">
				<label for="new_user_pw_re">변경할 비밀번호확인</label>
				<input type="password"
					class="form-control" id="new_user_pw_re" name="new_user_pw_re"
					placeholder="변경할 비밀번호 확인">
			</div>
			
			<div class="form-group">
				<label for="user_name">이름*</label> <input type="text"
					class="form-control" id="user_name" name="user_name"
					placeholder="이름" value="${loginInfo.userName}">
			</div>
			<div class="form-group">
				<label for="tel">휴대폰번호</label> <input type="text"
					class="form-control" id="tel" name="tel"
					value="${loginInfo.tel}">
			</div>

			<div class="form-group" style="margin-bottom: 10px;">
				<label for="postcode" class="">우편번호</label>
				<div class="clearfix" style="margin-bottom: 10px;">
					<input type="text" class="form-control col-xs-8 " id="postcode"
						name="postcode" style="width: 65.1%; margin-right: 5px;"
						value="${loginInfo.postCode}" />
					<!-- 클릭 시, Javascript 함수 호출 : openDaumPostcode() -->
					<input type="button" value="우편번호 찾기"
						onclick='openDaumPostcode("postcode","addr1","addr2","addr3")'
						class="btn btn-warning col-xs-4" />
				</div>
			</div>
			<!-- 아 ! loginInfo 는 name 속성이구나 -->
			<div class="form-group">
				<label for="addr1">주소</label> <input type="text"
					class="form-control" id="addr1" name="addr1"
					value="${loginInfo.addr1}" />

			</div>

			<div class="form-group">
				<label for="addr2" style="margin-bottom: 10px;">상세주소</label>
				<input
					type="text" class="col-xs-6 form-control" id="addr2"
					placeholder="상세주소" name="addr2" style="margin-bottom: 10px;"
					value="${loginInfo.addr2}"/>
					<input
					type="text" class="col-xs-6 form-control" placeholder="참고항목"
					id="addr3" name="addr3" style="margin-bottom: 10px;" value="${loginInfo.addr3}" />

			</div>
			<div class="form-group">
				<label for="user_email">이메일*</label> <input type="email"
					class="form-control" id="user_email" name="user_email"
					value="${loginInfo.userEmail}">
			</div>


			<button type="submit" class="btn btn-primary join ">수정하기</button>
		</form>
	</div>
	<!-- Inner Wrap : celeb_start end-->
</div>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>


<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function openDaumPostcode(postcode_id, addr1_id, addr2_id, addr3_id) {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				if (data.userSelectedType === 'R') {
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraAddr !== '') {
						extraAddr = ' (' + extraAddr + ')';
					}
					// 조합된 참고항목을 해당 필드에 넣는다.
					document.getElementById("addr3").value = extraAddr;

				} else {
					document.getElementById("addr3").value = '';
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('postcode').value = data.zonecode;
				document.getElementById("addr1").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				document.getElementById("addr2").focus();
			}

		}).open();
	}
</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
