<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crud Member List</title>
</head>
<body>
	<h2>LIST</h2><hr/><br/>
<a href = "/crud/member/register">등록</a>


<table border ="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>사용자명</th>
		<th>등록일</th>
	</tr>
	<c:choose>
		<c:when test="${empty list }">
			<tr>
				<td colspan="5">회원 정보가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items = "${list }" var = "member">
				<tr>
					<td>${member.userNo}</td>
					<td>
					<!-- 여기를 잘못 넣으면 userNo이 안넘어가고 400이 나옴 -->
						<a href="/crud/member/read?userNo=${member.userNo}">${member.userId}</a>
					</td>
					<td>${member.userPw }</td>
					<td>${member.userName }</td>
					<td>
						<fmt:formatDate value="${member.regDate }" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>	
	</c:choose>
</table>	
<hr/>
<p>
	<a href="/springBoard/list">1. /springBoard/list</a> <!-- 누구나 접근 가능 -->
</p>
<p>
	<a href="/springBoard/register">2. /springBoard/register(ROLE_MEMBER 권한 필요/1,2)</a> <!-- 유저만 접근 가능 -->
</p>
<p>
	<a href="/springNotice/list">3. /springNotice/list</a> <!-- 누구나 접근 가능 -->
</p>
<p>
	<a href="/springNotice/register">4. /springNotice/register(ROLE_ADMIN 권한 필요/2,3)</a> <!-- admin만 접근 가능 -->
</p>
<hr/>
<!-- 
	인증(authentication : 로그인) 된 사용자의 경우 로그아웃 버튼을 보여줌 
	로그인 되어 있으면(true)이면 보이고
	로그인 안되어 있으면(false)이면 안보이고
-->
<sec:authorize access = "isAuthenticated()">
<%--   <security:logout logout-url="/logout" invalidate-session="true"/> --%>
	<form action="/logout" method="post">
		<input type="submit" value="로그아웃"/>
		<sec:csrfInput/>
	</form>
	
	<!-- 
	로그인 한 사용자 정보 확인하기 
	CustomUser 클래스의 private MemberVO memberVO 멤버 변수를 
	principal.memberVO로 포현함
	
	principal = User = UsreDetails(username, password, enabled, memberVO 등)
	-->
	<p>
		<!-- var = "memberVO" : JSTL의 변수 -->
		<sec:authentication property="principal.memberVO" var="memberVO"/>
	</p>
	<p>
		${memberVO }
	</p>
	<script type="text/javascript">
		let memberVO = "${memberVO}";
		console.log("memberVO : " + memberVO);
	</script>
</sec:authorize>
<!-- 
	인증(authentication : 로그인) 안 된 사용자의 경우 로그인 버튼을 보여줌 
	로그인 안되어 있으면 (true) 보이고
	로그인 되어 있으면 (false) 안보이고
-->
<sec:authorize access="isAnonymous()">
	<!-- CommonController.java에 해당 URI가 매핑되어 있음 -->
	<a href="/login">로그인</a>
</sec:authorize>
</body>
</html>