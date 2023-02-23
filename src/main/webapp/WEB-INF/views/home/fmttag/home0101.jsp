<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0101</title>
</head>
<body>
	<p>number : ${coin }</p>
	<p>curreny : <fmt:formatNumber value = "${coin }" pattern = "currency"/>
	<p>percent : <fmt:formatNumber value = "${coin }" pattern = "percent"/>
	<p>pattern : <fmt:formatNumber value = "${coin }" pattern = "pattern"/> 
	<p>pattern : <fmt:formatNumber value = "${coin }" pattern = "000,000"/> 
</body>
</html>