<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDIT LIST</title>
</head>
<body>
	<a href="/ddit/board/register">등록</a>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>

		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td>게시글이 존재하지 않습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dditBoard">
					<tr>
						<td>${dditBoard.boNo }</td>
						<td>
						<a href="/ddit/board/read?boNo=${dditBoard.boNo}">
								${dditBoard.boTitle }</a></td>
						<td>${dditBoard.boWriter }</td>
						<td>${dditBoard.boDate }</td>
						<td>${dditBoard.boHit }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<div>
		<form action="/ddit/board/search" method = "post">
		<select name="searchType">
			<option value="boTitle" <c:if test= "${type eq 'boTitle'}">selected</c:if>>제목</option>
			<option value="boWriter" <c:if test= "${type eq 'boWriter'}">selected</c:if>>작성자</option>
			<option value="both" <c:if test= "${type eq 'both'}">selected</c:if>>제목 + 작성자</option>
		</select> 
		<input type="text" name="searchWord"> 
		<input type="submit" value="검색">
		</form>  	
	</div>
</body>
</html>