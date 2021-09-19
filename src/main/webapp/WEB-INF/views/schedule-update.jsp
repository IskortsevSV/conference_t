<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule update Date</title>
</head>
<body>
<form:form action="saveSchedule" modelAttribute="schedule" method="POST">
    <form:hidden path="id"/>
    <form:hidden path="report"/>
    <form:hidden path="audience"/>
    <br>
    Date: <form:input path="dateTimeStart"/>


    <input type="submit" value="OK">
</form:form>
</body>
</html>
