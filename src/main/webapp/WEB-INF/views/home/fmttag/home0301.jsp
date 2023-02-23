<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0301</title>
</head>
<body>
	<p>now : ${now }</p>
	<p>date default : <fmt:formatDate value="${now }" type= "date" dateStyle ="default"/>
	<p>date short : <fmt:formatDate value="${now }" type= "date" dateStyle ="short"/>
	<p>date medium : <fmt:formatDate value="${now }" type= "date" dateStyle ="medium"/>
	<p>date long : <fmt:formatDate value="${now }" type= "date" dateStyle ="long"/>
	<p>date full : <fmt:formatDate value="${now }" type= "date" dateStyle ="full"/>
	<!-- 
		dataStyle에 대한 출력 형태를 보고 원하는 출력 패턴으로 설정한다.
	 -->

</body>
</html>