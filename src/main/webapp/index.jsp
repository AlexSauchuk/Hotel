<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Главная!!</title>
        <link rel="stylesheet" type="text/css" href="css/liststyle.css" media="all">
    </head>
    <body>
<<<<<<< HEAD
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
            </tr>
            <br>
        </c:forEach>
=======
    <ol class="rectangle">
        <li><a href="/servlet?entity=USER&action=GET_ALL">Пользователи</a></li>
        <li><a href="/servlet?entity=ROOM&action=GET_ALL">Комнаты</a></li>
    </ol>
>>>>>>> 7a10bbf86e232785ae7012f86561075f62debe5d
    </body>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item}</td>
        </tr>
        <br>
    </c:forEach>
</html>