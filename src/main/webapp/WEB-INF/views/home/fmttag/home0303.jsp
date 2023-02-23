<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0303</title>
</head>
<body>
	<p>now : ${now }</p>
	<p>time default : <fmt:formatDate value="${now }" type= "both" dateStyle ="default" timeStyle ="default"/>
	<p>time short : <fmt:formatDate value="${now }" type= "both" dateStyle ="short" timeStyle ="short"/>
	<p>time medium : <fmt:formatDate value="${now }" type= "both" dateStyle ="medium" timeStyle ="medium"/>
	<p>time long : <fmt:formatDate value="${now }" type= "both" dateStyle ="long" timeStyle ="long"/>
	<p>time full : <fmt:formatDate value="${now }" type= "both" dateStyle ="full" timeStyle ="full"/>
	<!-- 
		dataStyle에 대한 출력 형태를 보고 원하는 출력 패턴으로 설정한다.
	 -->

</body>
</html>