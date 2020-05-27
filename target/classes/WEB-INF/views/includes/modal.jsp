<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device=width, initial-scale=1">
<link rel="stylesheet" href="css/custom.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<head>
<meta charset="UTF-8">
<title>title</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<style>
 div.modifyModal { position:relative; z-index:1; display:none; }
 div.modalBackground { position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0, 0, 0, 0.8); z-index:-1; }
 div.modalContent { position:fixed; top:20%; left:calc(50% - 250px); width:600px; height:500px; padding:23px 20px; background:#fff; border-radius:10px;}
 div.modalContent textarea { font-size:16px;  padding:10px; width:560px; height:450px; resize:none; }
 div.modalContent button { font-size:20px; padding:5px 10px; margin:30px 0; background-color: #a74fff; border:1px solid #ccc; border-radius:10px; color:white; }
 div.modalContent button.modal_cancel { margin-left:10px; background-color: #fff; color:#191919; }
 
</style>
</head>

<body>
	<!-- 수정 modal -->
	<form method ="POST">
	<div class="modifyModal">

		<div class="modalContent">

			<div>
				<textarea id = "modal_brdCon" class="modal_brdCon" name="modal_brdCon"></textarea>
			</div>

			<div>
				<button type="button" class="modal_modify_btn">수정</button>
				<button type="button" class="modal_cancel">취소</button>
			</div>

		</div>

		<div class="modalBackground"></div>

	</div>
	</form>
	
	<script>
	
	</script>
</body>
</html>