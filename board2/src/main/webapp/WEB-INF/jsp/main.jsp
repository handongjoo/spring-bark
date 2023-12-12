<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<div>
		<c:forEach items="${list}" var="list">
			<div>${list.title}</div>
			<div>${list.content}</div>
			<div>${list.userId}</div>
		</c:forEach>
	</div>
</body>
</html>