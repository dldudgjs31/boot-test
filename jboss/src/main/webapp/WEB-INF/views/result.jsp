<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>upload file 목록</h1>
<c:forEach items="${files}" var="dto">
<p>${dto.fileName}<a href="${pageContext.request.contextPath}/download?uuid=${dto.uuid}&fileName=${dto.fileName}">[download]</a></p>

</c:forEach>

</body>
</html>