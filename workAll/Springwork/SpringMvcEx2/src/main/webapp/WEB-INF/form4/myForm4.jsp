<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 20.
  Time: 오전 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<h3 class="alert alert-danger">Post type Date Read - Map</h3>
<form action="/read4" method="post">
    <table class="table" style="width: 300px;">
        <tr>
            <th width="100">메뉴명</th>
            <td><input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <th width="100">가격</th>
            <td><input type="number" id="price" name="price"></td>
        </tr>
        <tr>
            <th width="100">수량</th>
            <td><input type="text" id="count" name="count"></td>
        </tr>
        <tr>
            <th width="100">사진</th>
            <td>
                <select name="photo" id="photo">
                    <c:forEach var="s" begin="1" end="12">
                        <option>${s}.jpg</option>
                    </c:forEach>
                </select>
                <img src="http://192.168.0.59:8080/study0520/image/1.jpg" alt="" width="40" border="1" id="fphoto" name="fphoto">
            </td>

            <script>
                $("#photo").change(function (){
                    $("#fphoto").attr("src","http://192.168.0.59:8080/study0520/image/" + $(this).val() );
                })
            </script>
        </tr>
        <tr>
            <td colspan="100%">
                <button>폼 전송</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
