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
	<h1>server.log</h1>
	<Br>
	<Br>
	<div style="width: 100%;">
		<c:forEach var="array" items="${result}">
			<p>${array}</p>
		</c:forEach>

	</div>

</body>
</html>