<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<h2> Registration only Listener</h2>
<br>

<form:form action="saveUser"  modelAttribute="user" method="post">
    <form:hidden path="id"/>
    Name: <form:input path="userName"/>
    <br><br>
    Password: <form:input type="password" path="userPassword"/>
    <br><br>
    Authority:  <form:input path="enabled"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>





</body>
</html>
