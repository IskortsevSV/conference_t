<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>For speakers</title>
</head>
<body>

<h2> Only speakers </h2>

schedules change Datetime
have List Talks CRUD

<br><br>
<h2>Talks:</h2>
<br>
<a href="/speaker/add">Add Talk</a>
<br><br>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Report</th>
        <th>Speaker</th>
        <th>Optional</th>
    </tr>
    <c:forEach var="talk" items="${talks}">
        <c:url var="updateButton" value="/speaker/updateTalk"> <%--создаем link--%>
            <c:param name ="talkId" value = "${talk.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/speaker/deleteTalk"> <%--создаем link--%>
            <c:param name ="talkId" value = "${talk.id}"/>
        </c:url>
        <tr>
            <td>${talk.id}</td>
            <td>${talk.report}</td>
            <td>${talk.speakerName}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href='${updateButton}'"/>
                <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>
<h2>Schedule:</h2>
<br><br>
<table border="1">
    <tr>

        <th>ID</th>
        <th>Date</th>
        <th>Report</th>
        <th>Audience</th>
        <th>Speaker</th>
        <th>Optional</th>

    </tr>
    <c:forEach items="${schedules}" var="schedule">

        <c:url var="updateButton" value="/speaker/updateSchedule"> <%--создаем link--%>
            <c:param name ="scheduleId" value = "${schedule.id}"/>
        </c:url>
       <%-- <c:url var="deleteButton" value="/speaker/deleteSchedule"> &lt;%&ndash;создаем link&ndash;%&gt;
            <c:param name ="scheduleId" value = "${schedule.id}"/>
        </c:url>--%>
        <tr>
            <td>${schedule.id}</td>
            <td>${schedule.dateTimeStart}</td>
            <td>${schedule.reportName}</td>
            <td>${schedule.audienceName}</td>
            <td>${schedule.userName}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href='${updateButton}'"/>
            <%--    <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>--%>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
