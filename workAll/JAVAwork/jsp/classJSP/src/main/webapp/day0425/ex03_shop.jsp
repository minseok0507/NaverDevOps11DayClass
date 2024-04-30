<%@ page import="java.util.List" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.example.classjsp.data.dto.ShopDto" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 25.
  Time: 오후 4:24
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

        div.shop {
            float: left;
            margin: 5px;
            border: 2px solid gray;
            border-radius: 20px;
            padding: 5px;
            width: 200px;
            height: 250px;
            text-align: center;
        }

        .shop b {
            font-size: 0.3em;
        }
    </style>
    <title>Title</title>

</head>
<%
    List<ShopDto> shopDtoList = new Vector<ShopDto>();
    shopDtoList.add(new ShopDto("보석머리띠", "30.jpg", "orange", 23000, 3));
    shopDtoList.add(new ShopDto("화이트자켓", "31.jpg", "pink", 35000, 3));
    shopDtoList.add(new ShopDto("꽃머리끈", "26.jpg", "yellow", 8000, 3));
    shopDtoList.add(new ShopDto("플렛슈즈", "14.jpg", "green", 32000, 3));
    shopDtoList.add(new ShopDto("쁘띠스카프", "30.jpg", "orange", 67000, 3));
    shopDtoList.add(new ShopDto("쁘띠스카프", "30.jpg", "orange", 67000, 3));

    shopDtoList.add(new ShopDto("쁘띠스카프", "30.jpg", "orange", 67000, 3));


%>
<body>
<%
    for (int i = 0; i < shopDtoList.size(); i++) {
%>
<div class="shop">
    <img src="./img/shop/<%=shopDtoList.get(i).getPhoto()%>" alt="">
    <h4 style="color: <%=shopDtoList.get(i).getColor()%>"><%=shopDtoList.get(i).getName()%>
    </h4>
    <span><%=shopDtoList.get(i).getPrice()%>원 <b>잔여 개수:<%=shopDtoList.get(i).getCount()%></b></span>
</div>
<%
    }
%>


</body>
</html>
