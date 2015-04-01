<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<c:choose>
        <c:when test="${team.isNew()}">
            <c:set var="method" value="post"/>
        </c:when>
        <c:otherwise>
            <c:set var="method" value="put"/>
        </c:otherwise>
    </c:choose>

    <h2>
        <c:if test="${team.isNew()}">New </c:if>
        Team
    </h2>

	<form:form modelAttribute="team" method="${method}">
		
		<form:input path="name"/>
		<form:errors path="name" />
		
		<c:choose>
       		<c:when test="${team.isNew()}">
          		<button type="submit">Add Team</button>
          	</c:when>
          	<c:otherwise>
          		<button type="submit">Update Team</button>
          	</c:otherwise>
		</c:choose>

    </form:form>
