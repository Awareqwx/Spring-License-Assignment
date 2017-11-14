<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New License</title>
</head>
<body>
    <h2>New License</h2>
    <form:form method="post" action="/licenses/license/new"  modelAttribute="license">
        <form:label path="person">Person:
        <form:select path="person" items="${persons}" itemLabel="fullName"/>
        </form:label><br/>
        <form:label path="state">State:
        <form:input path="state"/>
        </form:label><br/>
        <form:label path="expirationDate">Expiration Date:
        <form:input type="date" path="expirationDate"/>
        <input type="submit">
        </form:label><br/>
    </form:form>
</body>
</html>