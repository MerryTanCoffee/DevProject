<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0501</title>
</head>
<body>
	<h3>HOME0501</h3>
	<hr/><br/>
	
	<c:if test = "${member.hobbyArray == null }">
		<p>member.hobbyArray == null</p>
	</c:if>
	
	
	<c:if test = "${member.hobbyArray eq null }">
		<p>member.hobbyArray eq null</p>
	</c:if>

</body>
</html>