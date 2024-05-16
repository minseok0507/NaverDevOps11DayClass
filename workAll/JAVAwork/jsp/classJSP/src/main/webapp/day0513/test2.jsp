<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 13.
  Time: 오전 10:19
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
<h5 class="alert alert-danger">JSTL study #2</h5>

<h5>servlet request print</h5>
<h6>날짜 : ${today}</h6>
<h6>급여 : ${money}</h6>
<h6>점수 : ${score}</h6>

<hr>

<h5>used JSTL fmt format print</h5>
<h6 class="alert alert-info">다양한 날짜 양식</h6>
<fmt:formatDate value="${today}" var="date1" pattern="YYYY-MM-dd"/> <br>
<fmt:formatDate value="${today}" pattern="YYYY-MM-dd hh:mm"/> <br>
<fmt:formatDate value="${today}" pattern="YYYY-MM-dd a hh:mm"/> <br>
<fmt:formatDate value="${today}" var="date2" pattern="YYYY-MM-dd EEEE"/> <br>

<h6>${date1}</h6>
<h6>${date2}</h6>

<hr>

<h6 class="alert alert-info">다양한 숫자 양식</h6>

<fmt:formatNumber value="${money}" type="currency"/> <br>
<fmt:formatNumber value="${money}" type="number"/> <br>
<fmt:formatNumber value="${money}" type="number" currencyCode="$"/> <br>
<fmt:formatNumber value="${money}" type="number" currencyCode="₩"/> <br><br>
<fmt:formatNumber value="${score}" maxFractionDigits="2"/> <br>
<fmt:formatNumber value="${score}" type="number"/> <br>
<fmt:formatNumber value="${score}" pattern="0.00"/> <br>

<hr>

<c:set value="45.2" var="num3"/>
<c:set value="0.032" var="num4"/>

num3 : ${num3}<br>
num4 : ${num4}
<h6>
    <fmt:formatNumber value="${num3}" pattern="0.00"/> <br>
    <fmt:formatNumber value="${num3}" pattern="0.##"/>
</h6>
<h6>
    <fmt:formatNumber value="${num4}" type="percent" maxFractionDigits="2"/> <br>
</h6>

</body>
</html>
