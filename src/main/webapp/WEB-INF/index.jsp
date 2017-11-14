<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
    <table>
        <tr>
            <th>FirstName</th>
            <th>LastName</th>
            <th>License#</th>
            <th>State</th>
            <th>Expiration Date</th>
        </tr>
        <c:forEach var="person" items="${persons}">
            <tr>
                <td><a href="/licenses/person/${person.getId()}">${person.getFirstName()}</a></td>
                <td><a href="/licenses/person/${person.getId()}">${person.getLastName()}</a></td>
                <td>${person.getLicense().getNumber()}</td>
                <td>${person.getLicense().getState()}</td>
                <td>${person.getLicense().getExpirationDate().toString()}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/licenses/person/new">New Person</a><br/>
    <a href="/licenses/license/new">New License</a>
</body>
</html>