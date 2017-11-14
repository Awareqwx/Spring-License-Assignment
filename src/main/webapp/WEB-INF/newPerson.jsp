<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Person</title>
</head>
<body>
    <h2>New Person</h2>
    <form:form method="post" action="/licenses/person/new" modelAttribute="person">
        <form:label path="firstName">First Name:
        <form:input path="firstName"/>
        </form:label><br/>
        <form:label path="lastName">Last Name:
        <form:input path="lastName"/>
        <input type="submit">
        </form:label><br/>
    </form:form>
</body>
</html>