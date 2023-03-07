<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item3 Modify</title>
</head>
<script type="text/javascript" src = "${pageContext.request.contextPath }/resources/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var itemId = ${item.itemId};
	var inputFile = $("#inputFile");
	
	$("#item").submit(function(event){
		event.preventDefault();
		
		var that = $(this); // 현재 누른 폼태그
		var str = "";
		$(".uploadedList a").each(function(index){
			var value = $(this).attr("href");
			value = value.substr(28);
			
			str += "<input type='hidden' name='files["+ index +"]' value='"+value+"'>";
		});
		console.log(str);
		that.append(str);
		that.get(0).submit(); // form의 첫번째를 가져와서 submit() 처리를 해라!
	})
	
	
	
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
			
				var str = "";
				if(checkImageType(data)) { // 이미지이면 이미지 태그를 이용한 출력형태
					str += "<div>";
					str += "	<a href = '/item3/displayFile?fileName="+ data + "'>";
					str += "	<img src = '/item3/displayFile?fileName=" + getThumbnailName(data)+ "'/>";
					str += "	</a>";
					str += "	<span>x</span>";
					str += "</div>";
				} else { // 파일이면 파일명에 대한 링크로만 출력
					str += "<div>";
					str += "	<a href ='/item3/displayFile?fileName="+data+"'>" +getOriginalName(data) + "</a>";
					str += "	<span>x</span>";
					str += "</div>";
				}
				$(".uploadedList").append(str);
			}
			
		});
	});
	
	// x를 누르면 삭제되는 function
	$(".uploadedList").on("click","span",function(){
		$(this).parent("div").remove();
	});
	
	
	
	// 경로에 itemId를 포함함
	$.getJSON("/item3/getAttach/" + itemId, function(list){
		
		$(list).each(function(){
			console.log("data : " + this);
			var data = this;
			var str = "";
			
			if(checkImageType(data)) { // 이미지이면 이미지 태그를 이용한 출력형태
				str += "<div>";
				str += "	<a href = '/item3/displayFile?fileName="+ data + "'>";
				str += "	<img src = '/item3/displayFile?fileName=" + getThumbnailName(data)+ "'/>";
				str += "	</a>";
				str += "	<span>x</span>";
				str += "</div>";
			} else { // 파일이면 파일명에 대한 링크로만 출력
				str += "<div>";
				str += "	<a href ='/item3/displayFile?fileName="+data+"'>" +getOriginalName(data) + "</a>";
				str += "	<span>x</span>";
				str += "</div>";
			}
			$(".uploadedList").append(str);
		});
	});
	
	
	
	function getOriginalName(fileName){
		if(checkImageType(fileName)){
			return;
		}		
		var idx = fileName.indexOf("_") + 1;
		return fileName.substr(idx);
	}
	function getThumbnailName(fileName){
		var front = fileName.substr(0,12);
		var end = fileName.substr(12);
		
		console.log("front : " + front);
		console.log("end : " + end);
		
		return front + "s_" + end;
	}
	
	function checkImageType(fileName){
		var pattern = /jpg|gif|png|jpeg/i;
		return fileName.match(pattern); // 패턴과 일치하면 true (너 이미지 맞구나?)
	}
	
	
	
});

</script>
<body>
	<h2>Modify</h2><hr/><br/>
	
	<form action = "/item3/modify" method="post"  enctype="multipart/form-data" id = "item">
	<input type="hidden" name = "itemId" value = "${item.itemId }">
	
		<table>
			<tr>
				<td>상품명</td>
				<td>
					<input type = "text" name ="itemName" id = "itemName" value = "${item.itemName }"/>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type = "text" name ="price" id = "price" value = "${item.price }"/>
				</td>
			</tr>
			
			<tr>
				<td>파일</td>
				<td>
					<input type = "file" id = "inputFile"/>
					<div class = "uploadedList"></div>
				</td>
			</tr>
			<tr>
				<td>개요</td>
				<td>
					<textarea rows="10" cols="30" name ="description" id = "description">${item.description }</textarea>
				</td>
			</tr>
		</table>
		
		<div>
			<button type = "submit" id = "modifyBtn">수정</button>
			<button type = "button" id ="listBtn" onclick="javascript:location.href='/item3/list'">리스트</button>
		</div>
		</form>
</body>
</html>