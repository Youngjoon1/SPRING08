<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정페이지</h1>
	<form action="modify" enctype="multipart/form-data" method="post">
		<input type="text" name="id" readonly value="${info.id}"><br>
		<input type="text" name="name" value="${info.name}"><br>
		<input type="file" name="file" value="${info.imgName}"><br>
		<input type="submit" value="수정">
		
	</form>
	
	<h1>아이디까지 고쳐보자</h1>
	<form action="modifyName" enctype="multipart/form-data" method="post">
		<input type="hidden" name="oriId" value="${info.id}">
		<input type="text" name="id" value="${info.id}"><br>
		<input type="text" name="name" value="${info.name}"><br>
		<input type="file" name="file" value="${info.imgName}"><br>
		<input type="submit" value="수정">
		
	</form>
</body>
</html>