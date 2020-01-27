<%--
  Created by IntelliJ IDEA.
  User: diana.damian
  Date: 2019-10-21
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>The main page of the app</title>
</head>
<body>
    <h2>${message}</h2>

    <form:form method="post" modelAttribute="user" action="/create">
            <form:label path="name" /> <form:input path="name" name="name"/>
             <form:label path="password" /> <form:input path="password" name="password"/>
                 <input type="submit" value="Submit" />
            </form:form>
</body>
</html>






