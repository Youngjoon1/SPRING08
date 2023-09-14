<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	function test() {
		let n = document.getElementById("name").value;
		let a = $("#age").val();
		let form = {name : n, age : a}; <%-- InfoDTO 와 키값을 동일하게 맞추어 주어야한다 --%>
		$.ajax({
			url : "result03",
			type : "post",
			data : JSON.stringify(form),//서버로 전송할 데이터 ,서버는 object타입을 받을 수가 없어서 json형식으로 바꾸어 준다.
			contentType : "application/json; charset=utf-8", //서버로 보낼 데이터 유형 지정
			dataType : "json" , //서버로 받을 리턴 타입 지정 (어떠한 형태로 받을 것인가 지정)
			success : function(data) {
				console.log("이름 : " + data.name)
				console.log("나이 : " + data.age)
			}
		});
	}
</script>
</head>
<body>
	name : <input type="text" name="name" id="name"><br>
	age : <input type="text" name="age" id="age"><br>
	<input type="button" onclick="test()" value="전송"><br>
</body>
</html>