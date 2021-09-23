<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<h2> Registration only Listener</h2>
<br>

<form:form action="saveUser" modelAttribute="user" method="post">
    <form:hidden path="id"/>
    Name: <form:input path="userName"/>
    <br><br>
    Password: <form:input type="password" path="userPassword"/>
    <br><br>
    <security:authorize access="hasRole('ADMIN')">
        <form:hidden path="authority.id" value="${user.id}"/>
        Enabled: <form:input path="enabled" value="1"/>
        <br><br>
        Authority: <form:input path="authority.authority" value="ROLE_LISTENER"/>
        <br><br>
    </security:authorize>

    <input type="submit" value="OK">
</form:form>


</body>
</html>
