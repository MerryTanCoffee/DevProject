<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>김지선의 템플릿</title>
</head>
<body>

	<h3>springNotice Register 로그인 한 회원만 접근가능</h3>
	
<form action="/logout" method="post">
<input type="submit" value="로그아웃">
<sec:csrfInput/>
</form>	
</body>
</html>