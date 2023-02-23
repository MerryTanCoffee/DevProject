<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0304</title>
</head>
<body>
	<p>now : ${now }</p>
	<p>pattern : <fmt:formatDate value="${now }" pattern ="yyy-MM-dd HH:mm:ss"/>
	<p>pattern : <fmt:formatDate value="${now }" pattern ="a h:mm"/>
	<p>pattern : <fmt:formatDate value="${now }" pattern ="z a h:mm"/>
	<!-- 
		dataStyle에 대한 출력 형태를 보고 원하는 출력 패턴으로 설정한다.
	 -->

</body>
</html>