<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0204</title>
</head>
<body>
	<p>coin : ${coin }</p>
	<fmt:parseNumber value = "${coin }" var = "coinNum" pattern = "#,#00.0#"/>
	<p>coinNum : ${coinNum }</p>
	
	<!-- parseNumber로 인식이 잘 되지 않는다..
		하여 formatNumber로 설정한다.
		
		parseNumber로 pattern을 지정하는 건 "#,#00.0#" 형태로 설정한 패턴이 먹히기는 하나 
		이마저도 안된다.(formatNumber)로 설정하기 -->
</body>
</html>