<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix ="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form</title>
</head>
<body>
<h2>Spring Form</h2><hr/><br/>

<h3>2) 모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.</h3>
<form:form action = "/formtag/register" method = "post" modelAttribute="member">
	<table>
		<tr>
			<td></td>
			<td>
			<form:checkboxes items ="${hobbyMap }" path ="hobbyList"/>
			</td>
		</tr>
	</table>
		<form:button name = "register">등록</form:button>
</form:form>
 
</body>
</html>