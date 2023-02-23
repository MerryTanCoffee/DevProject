<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0701</title>
</head>
<body>
	<h3>HOME0701</h3>
	<hr/><br/>
	
	<c:forEach items = "${member.hobbyArray }" var = "hobby">
		${hobby }<br/>
	</c:forEach>
	
</body>
</html>