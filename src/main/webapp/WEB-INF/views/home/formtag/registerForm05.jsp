<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterForm05</title>
</head>
<body>
	<h2>Spring Form</h2><hr/><br/>
	
	<h3>5) 컨트롤러 메서드의 매개변수로 자바빈즈 객체가 전달이 되면 기본적으로 다시 화면으로 전달한다.</h3>
	
	<form:form action = "/formtag/register" method = "post" modelAttribute = "member">
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