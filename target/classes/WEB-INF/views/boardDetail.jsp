<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.8/js/solid.js"
	integrity="sha384-+Ga2s7YBbhOD6nie0DzrZpJes+b2K1xkpKxTFFcx59QmVPaSA8c7pycsNaFwUK6l"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.8/js/fontawesome.js"
	integrity="sha384-7ox8Q2yzO/uWircfojVuCQOZl+ZZBg2D2J5nkpLqzH1HY0C1dHlTKIbpRz/LG23c"
	crossorigin="anonymous"></script>
<link
	href="${pageContext.request.contextPath}/resources/assets/css/detailView.css"
	rel="stylesheet" />
<%@ include file="/WEB-INF/views/includes/topMenu.jsp"%>
<%@ include file="/WEB-INF/views/includes/modal.jsp"%>
<div class="wrap">
	<div class="contianer">
		<div class="contents_2" data-boardNum ="${boardItem.boardIdx}">
			<h3 class="customer_center"
				style="position: relative; left: 28%; top: 30;">고객센터</h3>
			<h4 class="title" style="margin-top: 34px;">${boardItem.title}</h4>
			<form action="${pageContext.request.contextPath}/deleteOk.do" method="post" id="dfrm">
				<input type="hidden" name="boardIdx" value="${boardItem.boardIdx}" />
				<input type="hidden" name="userId" value="${boardItem.userId}" />
			</form>
			<form action="${pageContext.request.contextPath}/CommentWriteOk.do" method="post" id="dfrm">
				<input type="hidden" name="boardIdx" value="${boardItem.boardIdx}" />
				<input type="hidden" name="userId" value="${boardItem.userId}" />
			</form>
			<div class="update_button" >
				<button type="button" name="modify" class="modify btn btn-default" >수정</button>
				
				<button type="button" name="delete" class="btn btn-danger btn-delete">삭제</button>
			</div>
			<span class="fa fa-comment" aria-hidden="true"style="margin-left: 8px;"></span> 
			No.<span class="board_idx"  style="color: crimson;" name="boardIdx" data-board-idx="${boardItem.boardIdx}">${boardItem.boardIdx}</span>
			
		
			<div class="user" name="userId">
				${boardItem.userId}
				</div>
			<span class="reg_date float-right">${boardItem.regDate.substring(0,10)}</span>
			
			<div class="question" name="content"><c:out value="${boardItem.content}" /></div>
			<div class="total_comment">
				<span class="comment_count">1</span>댓글
			</div>
			<div class="answer">안녕하세요 셀럽몰은 다른 조건없이 생성할 수 있도록 설정되어있습니다. 서비스
				가이드의 초보자 퀘스트 또는 셀럽 가이드를 확인해주시길 바랍니다. 감사합니다.</div>
			<div class="write_comment ">

				<!--본문 작성-->

				<div>
					<textarea name="comment_content" style="resize: none;"
						class="comment_text float-left" cols="150" rows="5"></textarea>
					<!--댓글 등록 버튼-->

					<div class="regist_button" id="btn">
						<button class="btn_regist">등록</button>
					</div>

				</div>
			</div>
			<form action="${pageContext.request.contextPath}/CommentWriteOk.do" method="post" >
			<div class="comment">

				<div>
					sooblair84<br> <span style="font-size: 8px; color: lightgray">2020-04-29</span>
				</div>

				<!--본문 내용-->

				<div class="text_wrapper">안녕하세요</div>

				<!--버튼-->

				<div class="btn-group" id="btn">
					<!--댓글 작성자만 수정, 삭제 가능하도록-->
					<button name="modify" class="btn btn-wraning">
						<a href="#">수정</a>
					</button>
					<button class="btn ">
						<a href="#">삭제</a>
					</button>
				</div>

			</div>
			</form>
		</div>
		<!--contents end-->

	</div>
	<!--container end-->
</div>
<!--wrap end-->

<!-- 수정버튼 눌렀을 때 -->
<script>
	$(document).on("click", ".modify", function() {
		$(".modifyModal").attr("style", "display:block;").fadeIn(1000);
		var brdNum = $(".board_idx").text();
		var brdCon = $(this).parent().parent().children(".question").text();
		var modal_brdCon = $("#modal_brdCon").text(brdCon);
		var userId = $.trim($(".user").text());
		console.log(userId);
	});
</script>

<!-- 수정 액션 -->
<script>
	$(".modal_modify_btn").click(function(){
		var modifyConfirm = confirm("정말로 수정하시겠습니까?");
		
		if(modifyConfirm){
			var boardIdx = $(".board_idx").data("board-idx");
			var data = {
					boardIdx : boardIdx,
					content : $("#modal_brdCon").val(),
					userId : $.trim($(".user").text())
				// json 형태로 데이터 생성	
			};
			
			$.ajax({
				url : "/editOk.do",
				type : "post",
				data : data,
				success : function(result){
					
					//result의 값에 따라 동작
					if(result == 1){
						alert("수정 되었습니다!");
						location.href = "/detail.do?boardIdx="+boardIdx;
					}else{
						//본인이 아닌경우
						alert("작성자 본인만 할 수 있습니다.");
					}
				},
				error: function(){
					//로그인하지 않아서 에러가 발생한 경우
					alert("로그인 후 이용 가능합니다.");
				}
				
			});	
		}
	});
</script>


<!-- 모달 창에서 취소 눌렀을 때 -->
<script>
	$(".modal_cancel").click(function() {
		$(".modifyModal").attr("style", "display:none;").fadeOut(1000);
	});
</script>

<script>
	$(function() {
		$(".btn-delete").click(function() {
			$("#dfrm").submit();
		})
	});
</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>