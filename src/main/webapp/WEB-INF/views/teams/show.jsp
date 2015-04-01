<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team Details</title>
</head>
<body>

	<h1>Team</h1>
	<p>
		${team.name}
	</p>
	
	<a href="<spring:url value='/teams/${team.id}/edit' htmlEscape='true' />">
		Edit team
	</a>

</body>
</html>