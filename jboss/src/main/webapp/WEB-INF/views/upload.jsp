<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=dege">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/webjars/bootstrap/5.01/css/bootstrap.min.css">
</head>
<body>
	<h1>upload-test</h1>
	<div style="width: 100%;">
		<form class="form" method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
			<input type="file" name="uploadfile" multiple="multiple">
			<input type="submit">
		</form>
	</div>

</body>
</html>