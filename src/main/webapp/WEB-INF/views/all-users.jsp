<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>

<h2>For admin</h2>
<br><br>

CRUD change user listener to speaker
ADD talks
ADD rooms

<br><br>
<a href="/registration">Add User</a>
<br><br>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Enabled</th>
        <th>Authority</th>
        <th>Options</th>
    </tr>
    <c:forEach var="user" items="${users}">

        <c:url var="updateButton" value="/admin/updateInfo"> <%--создаем link--%>
            <c:param name ="userId" value = "${user.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/admin/deleteUser"> <%--создаем link--%>
            <c:param name ="userId" value = "${user.id}"/>
        </c:url>
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.enabled}</td>
            <td>${user.authority.authority}</td>
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
<a href="/">Main page</a>
<br><br>

</body>
</html>
