<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix ="form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form</title>
</head>
<body>
<h2>Spring Form</h2>
<form:form action = "/formtag/button/result" method = "post" modelAttribute="member">
	<form:hidden path = "userId"/>
	<form:button name = "register"> 등록 </form:button>
</form:form>
</body>
</html>