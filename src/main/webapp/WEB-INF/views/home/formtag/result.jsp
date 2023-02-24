<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>

	<h2>Result</h2>
	<table>
		<tr>
			<td>유저ID</td>
			<td>${member.userId }</td>
		</tr>
	
		<tr>
			<td>PASSWORD</td>
			<td>${member.password }</td>
		</tr>
	
		<tr>
			<td>NAME</td>
			<td>${member.userName }</td>
		</tr>
	
		<tr>
			<td>E-mail</td>
			<td>${member.email }</td>
		</tr>
	
		<tr>
			<td>INTRODUCE</td>
			<td>${member.introduction }</td>
		</tr>
	
		<tr>
			<td>취미 목록</td>
			<td><c:forEach items = "${member.hobbyList }" var = "hobby">
				<c:out value = "${hobby }"/>
			</c:forEach></td>
		</tr>
	
	
	</table>

</body>
</html>