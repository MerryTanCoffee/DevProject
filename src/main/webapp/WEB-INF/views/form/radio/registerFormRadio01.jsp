<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form</title>
</head>
<body>
<h2>String Form</h2>
<br><hr>

<h3>1)모델 MAP타입의 데이터를 생성하여 추가한 후에 화면에 전달</h3>
	
<form:form action="/formtag/radio/result2" method="post" modelAttribute="member">
	<table>
		<tr>
			<td>성별</td>
			<td>
				<form:radiobutton path="gender" value = "male" label = "Male"/>
				<form:radiobutton path="gender" value = "female" label = "Female"/>
				<form:radiobutton path="gender" value = "other" label = "Other"/>
			</td>
		</tr>
	</table>
	<form:button name="register">등록</form:button>

</form:form>
</body>
</html>