<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm01_Error</title>
</head>
<body>
	<h2>Spring_Form</h2>
	<h3>1) 모델에 폼 객체를 추가하지 않으면 에러가 발생한다.</h3><hr/><br/>
	
	<form:form action="/formtag/register" method = "post" modelAttribute="member">
		<table>
			<tr>
				<td>아이디</td>
				<td>
				<form:input path="userId"/>
				<font color = "red">
					<form:errors path = "userId"></form:errors>
				</font>
				</td>
			</tr>
			<tr>	
				<td>이름</td>
				<td>
				<form:input path="userName"/>
				<font color = "red">
					<form:errors path = "userName"></form:errors>
				</font>
				</td>
			</tr>	
		</table>
		<form:button name = "register">등록</form:button>
	</form:form>
</body>
</html>