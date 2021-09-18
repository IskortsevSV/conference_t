<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Main</title>
</head>
<body>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>Welcome : ${pageContext.request.userPrincipal.name} |
        <a href="<c:url value="/logout" />" > Logout</a></h2>
</c:if>


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
<security:authorize access="hasRole('ADMIN')">
<a href="/admin/allUsers">Click to Admin</a>
</security:authorize>
<br><br>

<a href="/registration">Click to registration listener</a>

<br><br>
<a href="/speaker/all">Click to Speaker</a>
</body>




</html>
