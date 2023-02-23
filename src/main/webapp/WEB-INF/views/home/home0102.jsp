<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0102</title>
</head>
<body>
	<h3>HOME0102</h3>
	<table border="1">
		<tr>
			<td>\${member.hobbyArray}</td>
			<td>
				<c:forEach items = "${member.hobbyArray }" var = "hobby">
					${hobby }<br/>
				</c:forEach>
			</td>
		</tr>
		
		<tr>
			<td>
				\${member.hobbyArray[0] }<br/>
				${member.hobbyArray[0] }<br/>
			</td>
		</tr>
		
		<tr>
			<td>
				\${member.hobbyArray[1] }<br/>
				${member.hobbyArray[1] }<br/>
			</td>
		</tr>
		
		<tr>
			<td>
			\${member.hobbyList }<br/>
			</td>
			<td>
			<c:forEach items = "${member.hobbyList }" var = "hobby">
					${hobby }<br/>
			</c:forEach>
			</td>
		</tr>
		
		<tr>
			<td>
			\${member.hobbyList[0] }<br/>
			${member.hobbyList[0] }<br/>
			</td>
		</tr>
		
		<tr>
			<td>
			\${member.hobbyList[1] }<br/>
			${member.hobbyList[1] }<br/>
			</td>
		</tr>
	</table>
</body>
</html>