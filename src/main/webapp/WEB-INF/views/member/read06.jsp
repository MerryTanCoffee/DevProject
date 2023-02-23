<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read06</title>
</head>
<body>
<h3>6)</h3>

<p>Result</p>

ID : ${user.userId }<br/>
password : ${user.password }<br/>
name : ${user.userName }<br/>
email : ${user.email }<br/>
birthDay : ${user.birthDay }<br/>
생일 : ${user.birthDay}<br/>
성별 : ${user.gender }<br/>
 취미 : ${user.hobby }<br/><hr/>
 취미(배열) : <br/>
<c:forEach items = "${user.hobbyArray }" var = "hobby">
	${hobby }<br/>
</c:forEach><hr/>
취미(리스트) : <br/>
<c:forEach items ="${user.hobbyList }" var = "hobby">
	${hobby }<br/>
</c:forEach><hr/>
외국인 여부 : ${user.foreigner }<br/>
개발자 여부 : ${user.developer }<br/>
국적 : ${user.nationality }<br/>
우편번호 : ${user.address.postCode }<br/>
주소 : ${user.address.location }<br/>
<hr/>
카드번호 / 유효연월 <br/>
<c:forEach items = "${user.cardList }" var = "card">
${card.no }/${card.validMonth }<br/>
</c:forEach><hr/>
소유차량 (배열)
<c:forEach items = "${user.carArray}" var = "car">${car }<br/> </c:forEach><hr/>
소개 ${user.introduction}

::::::::::::END user.dateOfBirth  : ${user.dateOfBirth }<br/>

</body>
</html>