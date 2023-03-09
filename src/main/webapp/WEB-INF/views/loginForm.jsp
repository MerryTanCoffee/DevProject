<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>김지선의 템플릿</title>
</head>
<body>
<!-- 
로그인 시 /login 을 action에 써야함 요청 방식은 꼭 post
아이디는 username 비밀번호는 passwrod
 -->
 
 <h1>Loging</h1>
 <!-- 
 EL태그. Controller에서 옴
 model.addAttribute("error", "오류메세지")
 model.addAttribute("logout","로그아웃 페이지")
  -->
 <h2>${error }</h2>
 <h2>${logout }</h2>
<form action = "/login" method = "post">
<p><input type ="text" name = "username" value="" placeholder="아이디 입력 필"/></p>
<p><input type ="password" name = "password" value="" placeholder="비밀번호 입력 필"/></p>
<p><input type = "submit" value = "로그인"/></p>
<sec:csrfInput/>
</form>

</body>
</html>