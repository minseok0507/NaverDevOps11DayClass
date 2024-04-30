<%@ page import="com.example.classjsp.data.dao.ShopDao" %>
<%@ page import="com.example.classjsp.data.dto.ShopDto" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 29.
  Time: 오후 3:22
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

        img.img-photo {
            position: absolute;
            left: 320px;
            top: 100px;
            width: 150px;
            border: 3px solid gray;
        }
    </style>
    <title>Title</title>
    <%
        request.setCharacterEncoding("utf-8");

        Long id = Long.valueOf(request.getParameter("id"));

        ShopDao shopDao = new ShopDao();
        ShopDto shopDto = shopDao.selectById(id);
    %>
</head>
<body>
<div style="margin: 10px; width: 300px;">
    <form action="./updateAction.jsp" method="get">
        <table class="table table-bordered">
            <caption align="top">상품 수정</caption>
            <tr>
                <td width="100" class="table-danger">제품명</td>
                <td><input type="text" name="name" id="name" value="<%=shopDto.getName()%>"></td>
            </tr>
            <tr>
                <td width="100" class="table-danger">가격</td>
                <td><input type="number" name="price" id="price" value="<%=shopDto.getPrice()%>"></td>
            </tr>
            <tr>
                <td width="100" class="table-danger">갯수</td>
                <td><input type="number" name="count" id="count" value="<%=shopDto.getCount()%>"></td>
            </tr>
            <tr>
                <td width="100" class="table-danger">색상</td>
                <td><input type="color" name="color" id="color" value="<%=shopDto.getColor()%>"></td>
            </tr>
            <tr>
                <td width="100" class="table-danger">사진</td>
                <td>
                    <input type="hidden" id="photoIndex" value="<%=shopDto.getPhoto()%>">
                    <select name="photo" id="photo" class="form-select">
                        <%
                            for (int i = 1; i <= 34; i++) {
                                out.print("<option value=\"../img/shop/" + i + ".jpg\">상품번호 " + i + "</option>");
                            }
                        %>
                    </select>
                    <img src="" alt="" class="img-photo">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="hidden" id="id" name="id" value="<%=shopDto.getId()%>">
                    <button>전송</button>
                    <button onclick="history.go(-1)">이전으로</button>
<%--                    <button onclick="history.back()">이전으로</button>--%>
                </td>
            </tr>
        </table>
    </form>
</div>

<script>
    let selPhoto = document.getElementById("photo");
    let img = document.getElementsByClassName("img-photo")[0];
    selPhoto.addEventListener("change", function () {
        img.setAttribute("src", this.selectedOptions[0].value);
    })
    const photoPath = document.getElementById("photoIndex").value;
    const selOption = selPhoto.options;
    const arr = photoPath.split(".");

    let index = Number(arr[2].slice(-2));
    if (isNaN(index)) {
        index = Number(arr[2].slice(-1));
    }
    selPhoto.selectedIndex = index - 1;
    img.setAttribute("src", "../img/shop/" + index + ".jpg");
</script>
</body>
</html>
