<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>김지선 템플릿</title>
</head>
<body>
<h2>${SPRING_SECURITY_403_EXCEPTION.getMessage() }</h2>
<h2>${msg }</h2>
<p><img src ="/resources/images/access.jpg"/></p>
</body>
</html>