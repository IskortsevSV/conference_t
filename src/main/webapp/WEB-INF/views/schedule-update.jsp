<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule update Date</title>
</head>
<body>
<form:form action="saveSchedule" modelAttribute="schedule" method="post">
    <form:hidden path="id"/>
    <br>
    Date: <form:input path="dateTimeStart"/>
    <br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
