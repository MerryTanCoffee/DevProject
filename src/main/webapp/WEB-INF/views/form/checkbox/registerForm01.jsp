<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form</title>
</head>
<body>
	<h2>Spring Form</h2><hr/><br/>
	
	<h3>1) 모델에 기본 생성자로 생성한 폼 객체를 추가한 후 화면에 전달한다.</h3>
	<form:form action = "/formtag/checkbox/result" method = "post" modelAttribute="member">
		<table>
			<tr>
				<td>Developer</td>
				<td>
					<form:checkbox path="developer" value ="Y"/>
				</td>
			</tr>
			<tr>
				<td>Foreigner</td>
				<td>
					<form:checkbox path="foreigner" value ="true"/>
				</td>
			</tr>
			<tr>
				<td>Hobby</td>
				<td>
					<form:checkbox path="hobby" value = "Sports" label ="Sports"/>
					<form:checkbox path="hobby" value = "Movie" label ="Movie"/>
					<form:checkbox path="hobby" value = "Music" label ="Music"/>
				</td>
			</tr>
			<tr>
				<td>HobbyArray</td>
				<td>
					<form:checkbox path="HobbyArray" value = "Sports" label ="Sports"/>
					<form:checkbox path="HobbyArray" value = "Movie" label ="Movie"/>
					<form:checkbox path="HobbyArray" value = "Music" label ="Music"/>
				</td>
			</tr>
			<tr>
				<td>HobbyList</td>
				<td>
					<form:checkbox path="HobbyList" value = "Sports" label ="Sports"/>
					<form:checkbox path="HobbyList" value = "Movie" label ="Movie"/>
					<form:checkbox path="HobbyList" value = "Music" label ="Music"/>
				</td>
			</tr>
		</table>
		
		<form:button name = "register">등록</form:button>
	</form:form>
	
</body>
</html>