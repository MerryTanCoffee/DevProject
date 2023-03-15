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

<!-- 로그인 폼 페이지 -->

<div class="login-box" style="text-align:center;margin:auto">
  <div class="login-logo">
    <a href="../../index2.html"><b>Admin</b>LTE</a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Sign in to start your session</p>

		<!-- 
			요청 URI : /login
			요청 파라미터 : username = 2 & password = 1234 & remember-me = on
			요청 방식 : post
		 -->
	
      <form action="/login" method="post">
        <div class="input-group mb-3">
          <input type="text" name="username" class="form-control" placeholder="아이디 입력 필" required />
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" name="password" class="form-control" placeholder="비밀번호 입력 필"/>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <input type="checkbox" name="remember-me" id="remember">
              <label for="remember">
                Remember Me
              </label>
            </div>
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block">로그인</button>
          </div>
          <!-- /.col -->
        </div>
        <sec:csrfInput/>
      </form>
    </div>
    <!-- /.login-card-body -->
  </div>
</div>

<!-- 로그인 폼 페이지 끝 -->


</body>
</html>