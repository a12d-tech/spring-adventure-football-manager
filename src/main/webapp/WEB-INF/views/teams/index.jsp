<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teams</title>
</head>
<body>
	<h1>Teams</h1>
	
	<ul>
		<c:if test="${!empty teams}">
			<c:forEach var="team" items="${teams}">
	    		<li><c:out value="${team.name}"/></li>
	    	</c:forEach>
	   	</c:if>
	   	
	   	<c:if test="${empty teams}">
	   		No teams yet ! Let's create one
	    </c:if>
	</ul>
	
	<div>
		<jsp:include page="form.jsp"/>
	</div>
	
</body>
</html>