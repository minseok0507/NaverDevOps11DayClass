<%@ page import="com.example.classjsp.data.dao.ShopDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.classjsp.data.dto.ShopDto" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 29.
  Time: 오전 11:08
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
    </style>
    <title>Title</title>
</head>
<%
    ShopDao dao = new ShopDao();
    List<ShopDto> list = dao.selectAll();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
<div style="margin: 10px; width: 500px">
    <h5 class="alert alert-danger"><b>총 <%=list.size()%>개의 상품이 등록됨</b></h5>
    <button class="btn btn-danger" onclick="location.href='insertForm.jsp'">전송 폼 이동</button>

    <table class="table table-bordered">
        <tr class="table-danger">
            <th width="200">상품명</th>
            <th width="100">가격</th>
            <th>등록일</th>
        </tr>
        <%
            for (int i = 0; i < list.size(); i++) {%>
        <tr>
            <td><a href="./shopDetail.jsp?id=<%=list.get(i).getId()%>" style="text-decoration: none; color: black">
                <img src="<%=list.get(i).getPhoto()%>" alt="" height="50">
                <%=list.get(i).getName()%>
            </a></td>
            <td><%=list.get(i).getPrice()%></td>
            <td><%=sdf.format(list.get(i).getWriteday())%></td>
        </tr>
            <%}
        %>

    </table>
</div>


</body>
</html>
