<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 24.
  Time: 오후 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        form{
            display: flex;
            justify-content: center;
        }
    </style>
    <title>Title</title>
</head>
<body>
<form action="<c:url value="/login/action"/>" method="post">
    <table class="table table-bordered" style="width: 250px;">
        <caption align="top"><b>회원 로그인</b>
        </caption>
        <tr>
            <th width="100" class="table-success">아이디</th>
            <td><input type="text" name="myid" id="myid" class="form-control"></td>
        </tr>
        <tr>
            <th width="100" class="table-success">비밀번호</th>
            <td><input type="password" name="passwd" id="passwd" class="form-control"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button class="btn btn-outline-danger" onclick="login()">로그인</button>
            </td>
        </tr>
    </table>
</form>

<script>

</script>
</body>
</html>
