<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>공지사항 게시판</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">DDIT HOME</a></li>
								<li class="breadcrumb-item active">공지사항 게시판</li>
							</ol>
						</div>
					</div>
				</div>
			</section>

			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-tools">
										<form class="input-group input-group-sm" method = "post" id="searchForm" style="width: 440px;">
											<input type = "hidden" name = "page" id = "page"/>
										
											<select class="form-control" name = "searchType">
												<option value = "title" <c:if test = "${searchType ==  'title'}">selected</c:if>>제목</option>
												<option value = "writer" <c:if test = "${searchType ==  'writer'}">selected</c:if>>작성자</option>
											</select> 
											<input type="text" name="searchWord" value = "${searchWord }" class="form-control float-right" placeholder="Search">
											<div class="input-group-append">
												<button type="submit" class="btn btn-default">
													<i class="fas fa-search"></i>검색
												</button>
											</div>
										</form>
									</div>
									<h3 class="card-title">공지사항</h3>
								</div>
								<div class="card-body">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th style="width: 6%">#</th>
												<th style="width: px">제목</th>
												<th style="width: 12%">작성자</th>
												<th style="width: 12%">작성일</th>
												<th style="width: 10%">조회수</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>5</td>
												<td>제목입니다1</td>
												<td>관리자</td>
												<td>2022-12-12</td>
												<td>1456</td>
											</tr>
											<tr>
												<td>4</td>
												<td>제목입니다1</td>
												<td>관리자</td>
												<td>2022-12-12</td>
												<td>1456</td>
											</tr>
											<tr>
												<td>3</td>
												<td>제목입니다1</td>
												<td>관리자</td>
												<td>2022-12-12</td>
												<td>1456</td>
											</tr>
											<tr>
												<td>2</td>
												<td>제목입니다1</td>
												<td>관리자</td>
												<td>2022-12-12</td>
												<td>1456</td>
											</tr>
											<tr>
												<td>1</td>
												<td>제목입니다1</td>
												<td>관리자</td>
												<td>2022-12-12</td>
												<td>1456</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="card-footer clearfix">
									<ul class="pagination pagination-sm m-0 float-right">
										<li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
										<li class="page-item"><a class="page-link" href="#">1</a></li>
										<li class="page-item"><a class="page-link" href="#">2</a></li>
										<li class="page-item"><a class="page-link" href="#">3</a></li>
										<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>					
			</section>
</body>
</html>