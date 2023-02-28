<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDIT BOARD DETAIL</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
	var btnModify = $("#btnModify");
	var btnDelete = $("#btnDelete");
	var btnList = $("#btnList");
	var delForm = $("#delForm");
	
	
	btnModify.on("click", function(){
		delForm.attr("action", "/ddit/board/modify");
		delForm.attr("method", "get");
		delForm.submit();
		
	});
	
	btnDelete.on("click", function(){
		if(confirm("정말로 삭제합니까?")){
			delForm.submit();
		} else {
			delForm.reset();
		}
	});
	
	btnList.on("click", function(){
		location.href = "/ddit/board/list";
	});
	
});
</script>
<body>
	<h2>Detail</h2>
	<table border ="1">
		<tr>
			<td>제목</td>
			<td>${dditBoard.boTitle }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dditBoard.boWriter }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${dditBoard.boContent }</td>
		</tr>
		<tr>
			<td>태그1</td>
			<td>${dditBoard.tagList[0].tagName }</td>
		</tr>
		<tr>
			<td>태그2</td>
			<td>${dditBoard.tagList[1].tagName }</td>
		</tr>
		<tr>
			<td>태그3</td>
			<td>${dditBoard.tagList[2].tagName }</td>
		</tr>
	</table>
	<form action="/ddit/board/remove" id = "delForm" method = "post">
		<input type = "hidden" name = "boNo" value = "${dditBoard.boNo }"/>
	</form>
	<div>
		<button id = "btnModify">수정</button>
		<button id = "btnDelete">삭제</button>
		<button id = "btnList">목록</button>
	</div>
</body>
</html>