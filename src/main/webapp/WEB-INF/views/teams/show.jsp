<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
  
  <h4>Players</h4>
  <p>
    <ul>
      <c:if test="${!empty team.players}">
        <c:forEach var="player" items="${team.players}">
          <li>
            ${player.role} - ${player.firstname} ${player.lastname}, ${player.age} years
          </li>
        </c:forEach>
      </c:if>

      <c:if test="${empty team.players}">
        No players yet !
      </c:if>
    </ul>
  </p>

  <a href="<spring:url value='/teams/${team.id}/edit' htmlEscape='true' />">
    Edit team
  </a>

</body>
</html>
