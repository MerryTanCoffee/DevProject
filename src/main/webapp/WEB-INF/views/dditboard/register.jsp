<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDIT BOARD</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var board = $("#board");
		var btnRegister = $("#btnRegister");
		var btnList = $("#btnList");

		btnRegister.on("click", function() {
			if ($("#title").val() == null || $("#title").val() == "") {
				alert("제목을 입력해주세요");
				return false;
			}

			// 등록 / 수정인지에 따라 이동 경로를 달리한다.
			if ($("#btnRegister").text() == "수정") {
				board.attr("action", "/ddit/board/modify");
			}
			board.submit();
		});
		btnList.on("click", function() {
			location.href = "/ddit/board/list";
		});
	});
</script>
<body>
	<h2>REGISTER</h2>
	<hr />
	<br />
	<form:form action="/ddit/board/register" method="post"
		modelAttribute="board">
		<c:if test="${status eq 'u' }">
			<input type="hidden" name="boNo" value="${board.boNo }">
		</c:if>
		<table border="1">

			<tr>
				<td>제목</td>
				<td><input type="text" name="boTitle" id="title"  value="${board.boTitle }"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="boWriter" id=writer value="${board.boWriter }" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="20" cols="30" name="boContent" >${board.boContent }</textarea></td>
			</tr>
			
			<tr>
				<td>태그1</td>
				<td><input type="text" name="tagList[0].tagName" id="${board.tagList[0].tagName }" value="${dditBoard.tagList[0].tagName }"/></td>
			</tr>
			<tr>
				<td>태그2</td>
				<td><input type="text" name="tagList[1].tagName" id="${board.tagList[1].tagName }" value="${dditBoard.tagList[1].tagName }"/></td>
			</tr>
			<tr>
				<td>태그3</td>
				<td><input type="text" name="tagList[2].tagName" id="${board.tagList[2].tagName }"  value="${dditBoard.tagList[2].tagName }"/></td>
			</tr>
		</table>
		<c:set value="등록 " var="btnText" />
		<c:if test="${status eq 'u' }">
			<c:set value="수정" var="btnText" />
		</c:if>
		<div>
			<button type="submit" id="btnRegister">${btnText }</button>
			<button type="button" id="btnList">목록</button>
		</div>
	</form:form>
</body>
</html>