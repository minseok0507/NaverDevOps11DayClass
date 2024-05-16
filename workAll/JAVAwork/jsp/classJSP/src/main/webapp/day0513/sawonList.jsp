<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 13.
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>
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
<h5 class="alert alert-success">bitcamp sawon list</h5>

<form action="/bitcamp/sawon" method="post">
    <b>부서명 입력</b>
    <input type="text" name="search" style="width: 120px;" value="${param.search}">
    <button>검색</button>
</form>

<h2>${param.search} 부서직원검색결과</h2>
<table class="table table-bordered" style="width: 500px;">
    <tr>
        <th>번호</th>
        <th>사진</th>
        <th>사원명</th>
        <th>부서명</th>
        <th>나이</th>
        <th>입사일</th>
    </tr>
    <c:forEach varStatus="i" items="${list}" var="sawon">
        <tr>
            <td>${i.count}</td>
            <td><img src="../${sawon.photo}" alt="" width="40"></td>
            <td>${sawon.name}</td>
            <td>${sawon.buseo}</td>
            <td>${sawon.age}</td>
            <td>${sawon.birthday}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
