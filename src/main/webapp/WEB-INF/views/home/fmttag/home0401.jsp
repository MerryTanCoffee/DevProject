<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>    
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0401</title>
</head>
<body>
	<p>dateValue  : ${dateValue }</p>
	
	
	<!--  넘겨받은 날짜 데이터를 long 타입의 날짜 데이터가 들어왔을 때 변환하기 위해 dateStyle 포맷을 long으로 설정하고
		  변환하면 우리가 알고 있는 날짜 형식의 데이터로 변환된다.
		  
			long 스타일의 날짜 데이터 -> [long 스타일 변환 공간] -> 날짜 변환	  
			full 스타일의 날짜 데이터 -> [full 스타일 변환 공간] -> 날짜 변환	  
	-->
	<c:set value="2019년  2월  1일 (금)" var ="dateValue1"/>
	<c:set value="2019년  2월  1일 금요일" var ="dateValue2"/>
	<p>dateValue  : <fmt:parseDate value = "${dateValue1}" dateStyle="long" type = "date" var = "date"/></p>
	<p>dateValue  : <fmt:parseDate value = "${dateValue2}" dateStyle="full" type = "date" var = "date"/></p>
	<p>date : ${date }</p>

</body>
</html>