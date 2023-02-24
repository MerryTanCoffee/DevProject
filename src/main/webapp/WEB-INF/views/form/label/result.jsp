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
			<td>userId</td>
			<td>
				${member.userId }
			</td>
		</tr>
		<tr>
			<td>userName</td>
			<td>
				${member.userName }
			</td>
		</tr>
		<tr>
			<td>email</td>
			<td>
				${member.email }
			</td>
		</tr>
	</table>
	
</body>
</html>