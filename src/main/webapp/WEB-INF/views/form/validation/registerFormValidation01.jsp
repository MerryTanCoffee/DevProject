<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	아이디 값을 비워놓고 등록을 눌렀을 떄 누락된 값이므로 누락이 되었다는 메세지가 출력되어야 하는데
	출력이 안되는 건 validation을 하기 위한 설정이 form:error  만으로는 이뤄지지 않기 때문
	그렇다면 그 형태는 어디서 찾냐면 월요일에 찾을 것임.	
 -->

<form:form action="/formtag/validation/result" method="post" modelAttribute="member">
      <form:hidden path="userId"/>
      <table>
         <tr>
            <td>E-Mail</td>
            <td>
               <form:input path="email"/>
               <font color="red">
                  <form:errors path="email"/>
               </font>
            </td>
         </tr>
         <tr>
            <td>이름</td>
            <td>
               <form:input path="userName"/>
               <font color="red">
                  <form:errors path="userName"/>
               </font>
            </td>
         </tr>
      
      </table>
      <form:button name="register">등록</form:button>
   </form:form>
</body>
</html>