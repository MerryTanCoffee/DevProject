<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0901</title>
</head>
<body>
	<h3>HOME0901</h3>
	<hr/><br/>
	
	<c:import url="http://localhost/board/list"/>
	
	<c:import url="http://localhost/board/search">	
		<c:param name="keyword" value = "orange"/>
	</c:import>
	
	<br/>
	
	<p>상대URL - 절대 경로</p>
	<c:import url="http://localhost/board/list"/>
	
	<p>상대URL - 상대 경로</p>
	<c:import url="../../board/list.jsp"/>
	<br/>
</body>
</html>