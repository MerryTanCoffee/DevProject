<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterForm04</title>
</head>
<body>
	<h2>Spring Form</h2><hr/><br/>
	
	<h3>4) 폼 객체의 속성명과 스프링 폼 태그의 modelAttribute 속성 값이 일치하지 않으면 에러가 발생한다.</h3>
	
	<form:form action = "/formtag/register" method = "post" modelAttribute = "user">
		<table>
			<tr>
				<td>UserID</td>
				<td>
					<form:input path = "userId"/>
					<font color = "red">
						<form:errors path = "userId"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>
					<form:input path = "userName"/>
					<font color = "red">
						<form:errors path = "userName"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>password</td>
				<td>
					<form:input path = "password"/>
					<font color = "red">
						<form:errors path = "password"/>
					</font>
				</td>
			</tr>
		</table>
		
		<form:button name = "register">등록</form:button>
	</form:form>
</body>
</html>