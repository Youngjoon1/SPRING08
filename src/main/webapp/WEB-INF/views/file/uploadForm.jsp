<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>upload01</h1><br>
	<form action="upLoad1" method="post" enctype="multipart/form-data">
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="file" name="file"><br>
		<input type="submit" value="전송"><br>
	</form>
	<a href="views">내용 확인</a>
	
	<h1>upload02</h1><br>
	<form action="upLoad2" method="post" enctype="multipart/form-data">
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="file" name="file"><br>
		<input type="submit" value="전송"><br>
	</form>
	
	
	
	
</body>
</html>