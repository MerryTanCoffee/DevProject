<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crud Member List</title>
</head>
<body>
	<h2>LIST</h2><hr/><br/>
<a href = "/crud/member/register">등록</a>


<table border ="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>사용자명</th>
		<th>등록일</th>
	</tr>
	<c:choose>
		<c:when test="${empty list }">
			<tr>
				<td colspan="5">회원 정보가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items = "${list }" var = "member">
				<tr>
					<td>${member.userNo}</td>
					<td>
					<!-- 여기를 잘못 넣으면 userNo이 안넘어가고 400이 나옴 -->
						<a href="/crud/member/read?userNo=${member.userNo}">${member.userId}</a>
					</td>
					<td>${member.userPw }</td>
					<td>${member.userName }</td>
					<td>
						<fmt:formatDate value="${member.regDate }" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>	
	</c:choose>
</table>	
</body>
</html>