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
<h3>3) 모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.</h3>
<form:form action = "/formtag/selectbox/result2" method = "post" modelAttribute="member">
	<table>
	
		<tr>
			<td>소유차량</td>
			<td>
				<form:select path = "carList" items = "${carCodeMap}" multiple="true"/>
				
			</td>
		</tr>
	
	</table>
	<form:button name = "register">등록</form:button>
</form:form>

</body>
</html>