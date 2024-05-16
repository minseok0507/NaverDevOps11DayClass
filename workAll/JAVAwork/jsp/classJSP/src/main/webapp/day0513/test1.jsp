<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 13.
  Time: 오전 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<h5 class="alert alert-danger">JSTL study #1</h5>
<h6>메세지 : ${msg}, ${requestScope.msg}</h6> <%--requestScope생략 가능--%>
<h6>날짜 : ${today}</h6>
<h3>숫자 1 : ${num1}</h3>
<h3>숫자 2 : ${num2}</h3>
<hr>

<h3>JSTL Operator</h3>
<h5>PLUS : ${num1 + num2}</h5>
<h5>MINUS : ${num1 - num2}</h5>
<h5>MUL : ${num1 * num2}</h5>
<h5>DIV : ${num1 / num2}</h5>
<h5>DIV : ${num1 div num2}</h5>
<h5>MOD : ${num1 % num2}</h5>
<h5>MOD : ${num1 mod num2}</h5>

<hr>

<h5>if문</h5>
<c:if test="${num1 > num2}">
    <h4>num1 > num2</h4>
</c:if>
<c:if test="${num1 < num2}">
    <h4>num1 < num2</h4>
</c:if>

<hr>

<h5>jsp에서 jstl 변수 선언</h5>
<c:set var="name" value="이영자"/>
<c:set var="age" value="19"/>

<h5>이름 : ${name}</h5>
<h5>나이 : ${age}</h5>

</body>
</html>
