<%--
  Created by IntelliJ IDEA.
  User: SK
  Date: 04.04.2017
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify</title>
    <script>
        <%@include file ="/js/jquery-3.2.0.min.js"%>
    </script>
    <style>
        <%@include file="/bootstrap/bootstrap.min.css"%>
    </style>
</head>
<body>
<div class="container" style="padding-left: 0px;margin-left: 0px;width: 100%">
    <div class="row" style="width: 100%;position: relative">
        <div class="col-lg-12" style="width:15%;">
            <table class="table table-hover table-bordered">
                <thead>

                </thead>
                <tbody>
                    <tr>
                    <c:forEach var="arg" items="${args}">
                        <td><input type="text" style="width: 100%" value="${arg}"/></td>
                    </c:forEach>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
