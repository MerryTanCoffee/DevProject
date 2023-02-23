<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>    
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0402</title>
</head>
<body>
	<p>dateValue  : ${dateValue }</p>
	
	<p>dateValue  : <fmt:parseDate value ="${dateValue}" pattern = "yyyy-MM-dd HH:mm:ss" var = "date"/></p>
	<p>date : ${date }</p>

</body>
</html>