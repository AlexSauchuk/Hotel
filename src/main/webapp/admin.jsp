<%--
  Created by IntelliJ IDEA.
  User: SK
  Date: 27.03.2017
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin</title>
    <script>
        <%@include file ="/js/jquery-3.2.0.min.js"%>
        <%@include file="/js/adminJS.js"%>
    </script>
    <style>
       <%@include file="/bootstrap/bootstrap.min.css"%>
    </style>
</head>
<body>
<div class="container" style="padding-left: 0px;margin-left: 0px;width: 100%">
    <div class="row" style="width: 100%;position: relative">
        <div class="col-lg-3" style="width:15%;">
            <table class="table table-hover table-bordered">
                <tbody>
                    <c:forEach var="arg" items="${args}">
                        <tr><td><input type="text" style="width: 100%" disabled="disabled" value="${arg}" class="head"/></td></tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-lg-12" style="float: right;width: 85%;">
            <table class="table table-bordered table-hover" id="tableHotel">
            </table>
        </div>
    </div>
</div>
</body>
</html>
