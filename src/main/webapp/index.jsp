<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Главная!!</title>
        <link rel="stylesheet" type="text/css" href="styleindex.css" media="all">
    </head>
    <body>
    <a href="/servlet?page=admin.jsp&action=ADMIN_START">Администратор</a>
        <!-- "<c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
            </tr>
            <br>
        </c:forEach>" -->
    </body>
</html>