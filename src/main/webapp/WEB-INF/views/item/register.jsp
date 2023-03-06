<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item</title>
</head>
<body>
	<h2>Register</h2>
	<hr/><br/>
	
	<form:form action = "/item/register" method = "post" modelAttribute="item" enctype="multipart/form-data">
		<table>
			<tr>
				<td>상품명</td>
				<td>
					<input type = "text" name ="itemName" id = "itemName"/>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type = "text" name ="price" id = "price"/>
				</td>
			</tr>
			
			
			<tr>
				<td>파일</td>
				<td>
					<input type = "file" name =picture id = "picture"/>
				</td>
			</tr>
			<tr>
				<td>개요</td>
				<td>
					<textarea rows="10" cols="30" name ="descroption" id = "descroption"></textarea>
				</td>
			</tr>
		</table>
		<div>
			<button type = "submit" id = "registerBtn">등록</button>
			<button type = "button" id ="listBtn" onclick="javascript:location.href='/items/list'">리스트</button>
		</div>
	</form:form>
	
</body>
</html>