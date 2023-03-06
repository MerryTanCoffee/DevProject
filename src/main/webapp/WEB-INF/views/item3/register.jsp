<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item3 Register</title>
</head>
  <script type="text/javascript" src = "${pageContext.request.contextPath }/resources/plugins/jquery/jquery.min.js"></script>
<body>
	<h2>Register</h2><hr/><br/>
	
	<form action = "/item3/register" method = "post" enctype="multipart/form-data" id = "item">
		<table border="1">
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name = "itemName" id = "itemName"/>
				</td>
			</tr>
		
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name = "price" id = "price"/>
				</td>
			</tr>
		
			<tr>
				<td>파일</td>
				<td>
					<input type="file" id = "inputFile"/>
					<div class = "uploadedList">
					
					</div>
				</td>
			</tr>
		
			<tr>
				<td>개요</td>
				<td>
					<textarea rows="10" cols="30" name = "description"></textarea>
				</td>
			</tr>
		
		
		</table>
		<div>
		
			<button type="submit" id = "registerBtn">등록</button>
			<button type="button" id = "listBtn" onclick="javascript:location.href='/item3/list'">목록</button>
		
		</div>
	
	</form>
</body>


<script type="text/javascript">
$(function(){
	var inputFile = $("#inputFile");
	
	inputFile.on("change", function(event){
		console.log("change event");
		
		
		var files = event.target.files;
		var file = files[0];
		
		console.log(file);
		var formData = new FormData();
		formData.append("file", file); // 키 (자바클래스의 MultipartFile file 과 매핑됨)
		
		
		// cf) 동기처리는 form 태그로 보내면 서버에서 처리가 됨
		
		
		// 비동기이면서 파일데이터를 서버로 보내려면 폼 데이터를 만들어서 키와 밸류 형식으로 보내야한다.
		$.ajax({
			type : "post",
			url : "/item3/uploadAjax",
			data : formData,
			dataType : "text",	// 응답데이터 타입
			processData : false, // 파일데이터는 쿼리스트링으로 보내는 게 아니니까 해당 부분을 false 로
			contentType : false, // 기본 설정된 contentType은 false로 설정하고 multipart form data로 데이터를 보냄
			success : function(data) {
				console.log(data);
			}
			
		});
	});
});



</script>
</html>