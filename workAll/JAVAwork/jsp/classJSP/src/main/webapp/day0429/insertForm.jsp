<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 29.
  Time: 오전 11:17
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
        img.img-photo{
            position: absolute;
            left: 320px;
            top: 100px;
            width: 150px;
            border: 3px solid gray;
        }
    </style>
    <title>Title</title>
</head>
<body>
<div style="margin: 10px; width: 300px;">
    <form action="./insertAction.jsp" method="post">
        <table class="table table-bordered">
            <caption align="top">상품 등록</caption>
            <tr>
                <td width="100" class="table-danger">제품명</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td width="100" class="table-danger">가격</td>
                <td><input type="number" name="price" id="price"></td>
            </tr>
            <tr>
                <td width="100" class="table-danger">갯수</td>
                <td><input type="number" name="count" id="count"></td>
            </tr>
            <tr>
                <td width="100" class="table-danger">색상</td>
                <td><input type="color" name="color" id="color"></td>
            </tr>
            <tr>
                <td width="100" class="table-danger">사진</td>
                <td>
                    <select name="photo" id="photo" class="form-select">
                        <%
                            for (int i = 1; i <= 34; i++) {
                                out.print("<option value=\"../img/shop/" + i + ".jpg\">상품번호 " + i + "</option>");
                            }
                        %>
                    </select>
                    <img src="../img/shop/1.jpg" alt="" class="img-photo">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button>전송</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<script>
    var selPhoto = document.getElementById("photo");
    var img = document.getElementsByClassName("img-photo")[0];
    selPhoto.addEventListener("change",function (){
        img.setAttribute("src", this.selectedOptions[0].value);
    })
</script>

</body>
</html>
