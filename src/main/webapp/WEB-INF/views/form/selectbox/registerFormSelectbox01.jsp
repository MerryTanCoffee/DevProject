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
<h3>1) 모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.</h3>
<form:form action = "/formtag/selectbox/result" method = "post" modelAttribute="member">
	<table>
	
		<tr>
			<td>국적</td>
			<td>
				<form:select path = "nationality" items = "${nationalityCodeMap}"/>
			</td>
		</tr>
	
	</table>
	<form:button name = "register">등록</form:button>
</form:form>

</body>
</html>