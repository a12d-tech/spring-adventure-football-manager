<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<title>Football Manager - Home</title>
</head>
<body>

	<div>
		<h1>
			Welcome to Football Manager App
		</h1>
		<p>
			Here you can build your dream team.
		</p>
		<p>
			<a href="<spring:url value='/teams' htmlEscape='true' />">
				Let's get started
			</a>
		</p>
		
	</div>

</body>
</html>
