<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Persons</title>
</head>
<body>

<c:if test="${!empty persons}">
    <table class="tg">
    <tr>
        <th width="80">Person ID</th>
        <th width="120">Person Name</th>
        <th width="120">Person Country</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.country}</td>
            <td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>