<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>1) 모델에 기본 생성자로 생성한 폼 객체를 추가한 후 화면에 전달한다.</h3>
	<form:form action = "/formtag/register" method = "post" modelAttribute="member">
		<table>
			<tr>
				<td>소개</td>
				<td>
					<form:textarea path = "introduction" rows="10" cols ="30"/>
				</td>
			</tr>		
		</table>
	</form:form>
</body>
</html>