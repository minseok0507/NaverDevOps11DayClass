<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 13.
  Time: 오후 3:02
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
<h5 class="alert alert-danger">JSTL study #5</h5>
<form action="./study5" method="post">
    <input type="text" name="nara" id="nara">
    <br>
    <button>전송</button>
</form>
<h6>입력값 ${param.nara}</h6>
<c:choose>
    <c:when test="${param.nara == '하와이'}">
        <img src="./img/mycarimage/car1.png" width="50">
        <b style="color: red;background-color: yellow">하와이 바다 이쁨</b>
    </c:when>
    <c:when test="${param.nara == '미국'}">
        <img src="./img/mycarimage/car2.png" width="50">
        <b style="color: blue;background-color: red">미국</b>
    </c:when>
    <c:when test="${param.nara == '프랑스'}">
        <img src="./img/mycarimage/car3.png" width="50">
        <b style="color: white;background-color: blue">프랑스</b>
    </c:when>
    <c:when test="${param.nara == '스위스'}">
        <img src="./img/mycarimage/car4.png" width="50">
        <b style="color: white;background-color: red">스위스</b>
    </c:when>
    <c:otherwise>
        <img src="./img/mycarimage/car5.png" width="50">
        <b style="color: white;background-color: black">없음</b>
    </c:otherwise>
</c:choose>
</body>
</html>
