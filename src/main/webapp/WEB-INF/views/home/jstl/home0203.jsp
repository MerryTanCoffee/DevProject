<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0203</title>
</head>
<body>
	<h3>HOME0203</h3>
	<hr/><br/>
	
	<c:set var = "memberId">${member.userId }</c:set>
	
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${memberId}</td>
		
		</tr>
	
	</table>
	
</body>
</html>