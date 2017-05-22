<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Главная!!</title>
        <link rel="stylesheet" type="text/css" href="styleindex.css" media="all">
    </head>
    <body>
    <a href="/servlet?page=admin.jsp&action=ADMIN_START">Администратор</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=reservation_voucher&id=4">Электронный ваучер на проживание</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=reservation_confirm&id=1">Подтверждение брони</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=room_report&type=by_month&year=2017">Отчет по комнатам по месяцам</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=room_report&type=by_quarter&year=2017">Отчет по комнатам по кварталам</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=financial_report&type=by_month&year=2017">Годовой отчет по месяцам</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=financial_report&type=by_quarter&year=2017">Годовой отчет по кварталам</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=reservation_report&id=4">Брони пользователя</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=entity_csv_report&entity=room">Отчет по комнатам</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=entity_csv_report&entity=reservation">Отчет по броням</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=entity_csv_report&entity=room_type">Отчет по типам комнат</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=entity_csv_report&entity=user">Отчет по пользователям</a></br>
    <a href="/servlet?action=CREATE_DOCUMENT&docname=entity_csv_report&entity=role">Отчет по ролям</a></br>

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