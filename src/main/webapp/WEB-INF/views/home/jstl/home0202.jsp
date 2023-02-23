<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0202</title>
</head>
<body>
	<h3>HOME0202</h3>
	<hr/><br/>
	
	<c:set var = "memberId" value ="${member.userId }"/>
	
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${memberId}</td>
		
		</tr>
	
	</table>
	
</body>
</html>