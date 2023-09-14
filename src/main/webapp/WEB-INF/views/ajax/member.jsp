<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	function getUsers() {
		$.ajax({
			url : "users",
			type : "get",
			dataType : "json",
			success : function(list) {
				console.log(list);
				let msg = "";
				list.forEach((data)=>{
					msg +="<b> 이름 : "+ data.name +"</b><br>";
					msg +="<b> 나이 : "+ data.age +"</b><hr>";
				})
				$("#data").append(msg);
				$("#btn").html("더보기");
			},
			error : () => {
				alert("문제발생!!!");
			}
		});
	}
	function getUser() {
		let id = $("#name").val();
		$.ajax({
			//url : "getUser?id="+id,
			url : "getUser/"+id,
			type : "get",
			dataType : "json",
			success : function(data) {
				console.log(data)
				
				let msg = "";
				msg += "<b> 이름 : "+data.name+"</b><br>";
				msg += "<b> 나이 : "+data.age+"</b><br>";
				$("#data").html(msg);
			},
			error : function() {
				console.log("error");
			}
		})
	}
</script>
</head>
<body>
	<div id="data"></div>
	<button type="button" id="btn" onclick="getUsers()">목록보기</button>
	<br>
	검색할 이름 : <input type="text" id="name"><br>
	<button type="button" onclick="getUser()">하나데이터</button>
	
	
	
</body>
</html>