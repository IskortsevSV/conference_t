<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update talk</title>
</head>
<body>
<%----%>

<form:form action="saveTalk" modelAttribute="talk" method="get">
    <form:hidden path="id"/>
    <br>
    Report: <form:input path="report"/>
    <br>
    SpeakerName: <form:input path="speakerName" value="${pageContext.request.userPrincipal.name}"/>
    <br>
    <input type="submit" value="OK">
</form:form>





</body>
</html>
