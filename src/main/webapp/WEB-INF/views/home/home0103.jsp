<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0103</title>
</head>
<body>
<table border="1">
		<tr>
			<td>
			\${member.userId}<br/>
			${memberMap["userId"]}<br/>
			</td>
		</tr>
		
		<tr>
			<td>
				\${member.password }<br/>
				${memberMap["password"] }<br/>
			</td>
		</tr>
		
		<tr>
			<td>
				\${member.userName }<br/>
				${memberMap["userName"] }<br/>
			</td>
		</tr>
		
		<tr>
				<td>
				\${member.email }<br/>
				${memberMap["email"] }<br/>
			</td>
		</tr>
		
		<tr>
				<td>
				\${member.dateOfBirth }<br/>
				${memberMap["dateOfBirth"] }<br/>
			</td>
		</tr>
		
		<tr>
		
	</table>
</body>
</html>