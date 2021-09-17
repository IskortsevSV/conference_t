<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>

<h2>Hello ${user.userName}, your authority ${user.authority}</h2>

<h2>Schedules:</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Report</th>
        <th>Audience</th>
        <th>Speaker</th>
    </tr>
    <c:forEach items="${all}" var="schedule">
        <tr>
            <td>${schedule.id}</td>
            <td>${schedule.dateTimeStart}</td>
            <td>${schedule.reportName}</td>
            <td>${schedule.audienceName}</td>
            <td>${schedule.userName}</td>

            <%--td>
                <a href="edit?id=${customer.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="delete?id=${customer.id}">Delete</a>
            </td>--%>
        </tr>
    </c:forEach>
</table>

<br><br>
<a href="/admin/allUsers">Click to Admin</a>
<br><br>
<a href="/registration">Click to registration listener</a>
<br><br>
<a href="/speaker/all">Click to Speaker</a>

</body>
</html>
