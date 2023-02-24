<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form</title>
</head>
<body>
	<h2>Spring Form</h2><hr/><br/>
	
	<form:form action = "/formtag/label/result" method = "post" modelAttribute="member">
		<table>
		
			<tr>
				<td>
					<form:label path = "userId">유저 아이디</form:label>
						<form:input path = "userId"/>					
				</td>
			
			</tr>
			<tr>
				<td>
					<form:label path = "userName">userName</form:label>
					<form:input path = "userName"/>
				</td>
			
			</tr>
			<tr>
				<td>
					
					<form:label path = "email">email</form:label>
					<form:input path = "email"/>
				</td>
			
			</tr>
		</table>
	<form:button name = "register">등록</form:button>
	</form:form> 
</body>
</html>