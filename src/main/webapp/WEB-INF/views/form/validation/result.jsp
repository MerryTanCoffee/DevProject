<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	<h2>Result</h2><hr/><br/>
	<table>
		<tr>
			<td>아이디</td>
			<td>
				${member.userId }
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				${member.userName }
			</td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td>
				${member.password }
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				${member.email }
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				${member.gender }
			</td>
		</tr>
		<tr>
			<td>생일</td>
			<td>
				${member.birthDay }
			</td>
		</tr>
	</table>
	
</body>
</html>