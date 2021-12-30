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
	<h1>실행결과를 알고 싶은 명령어를 입력하세요.</h1>
	<Br>
	<Br>
	<div style="width: 100%;">
		<form class="form" method="post" action="${pageContext.request.contextPath}/logging-parameter" enctype="application/x-www-form-urlencoded">
			<input type="text" name="parameter">
			<input type="submit">
		</form>

	</div>

</body>
</html>