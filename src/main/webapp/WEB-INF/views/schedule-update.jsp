<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule update Date</title>
</head>
<body>
<form:form action="saveSchedule" modelAttribute="schedule" method="GET">

    <form:hidden path="id"/>
    <br>
    <br>
    Date: <form:input path="dateTimeStart"/>
    <br>
    <br>
    Report:  <form:input path="report"/>
    <br>
    <br>
    Report:
    <form:select path="reportName">
        <form:options items="${talks}"/>
    </form:select>
    <br>
    <br>
    Audience <form:input path="audience"/>
    <br>
    <br>
 <%--   Speaker <form:input path="userName"/>
    <br>
    <br>--%>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
