<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 13.
  Time: 오후 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
    <title>Title</title>
</head>
<body>
<h5 class="alert alert-danger">JSTL study #4</h5>
<h6>1~10 print</h6>
<c:forEach var="a" begin="1" end="10">
    <b>${a} </b>
</c:forEach>

<h6>1~20 odd print</h6>
<c:forEach var="a" begin="1" end="20" step="2">
    <b>${a} </b>
</c:forEach>

<h6>list</h6>
<table class="table table-striped" style="width: 400px;">
    <tr>
        <th width="50">count</th>
        <th width="50">index</th>
        <th width="100">color Value</th>
        <th width="100">color</th>
    </tr>
    <c:forEach var="a" items="${list1}" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${i.index}</td>
            <td>${a}</td>
            <td style="background-color: ${a}"></td>
        </tr>
    </c:forEach>
</table>

<h6>list1</h6>
<table class="table table-striped" style="width: 400px;">
    <tr>
        <th width="50">count</th>
        <th width="50">index</th>
        <th width="100">color Value</th>
        <th width="100">color</th>
    </tr>
    <c:forEach var="a" items="${list1}" varStatus="i" end="3">
        <tr>
            <td>${i.count}</td>
            <td>${i.index}</td>
            <td>${a}</td>
            <td style="background-color: ${a}"></td>
        </tr>
    </c:forEach>
</table>



<h6>list2</h6>
<table class="table table-striped" style="width: 400px;">
    <tr>
        <th width="50">count</th>
        <th width="50">index</th>
        <th width="100">color Value</th>
        <th width="100">color</th>
    </tr>
    <c:forEach var="a" items="${list1}" varStatus="i" begin="2" end="4">
        <tr>
            <td>${i.count}</td>
            <td>${i.index}</td>
            <td>${a}</td>
            <td style="background-color: ${a}"></td>
        </tr>
    </c:forEach>
</table>

<hr>

<h6>forTokens: , 분리</h6>
<h6>${flowers}</h6>
<c:forTokens var="a" items="${flowers}" delims="," varStatus="i">
    <h6>${i.count} : ${a}</h6>
</c:forTokens>
</body>
</html>
