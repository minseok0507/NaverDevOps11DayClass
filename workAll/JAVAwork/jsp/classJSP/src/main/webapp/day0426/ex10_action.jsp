<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 26.
  Time: 오후 3:50
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
    <%
        request.setCharacterEncoding("utf-8");

        String menu = request.getParameter("menu");
        String food = request.getParameter("food");
        String grade = request.getParameter("grade");
        String member  = request.getParameter("member");

        String[] arr = food.split(",");
        String foodImg = arr[0];
        String price = arr[1];

        if (member == null){
            member = "일반회원";
        } else {
            member = "우수회원";
        }

    %>
</head>
<body>
<h1><%=menu%></h1>
<img src="<%=foodImg%>" alt="">
<h2> <span><%=price%>원</span></h2>
<h3><span><%=grade%></span> <%=member%></h3>
<br><br>
<a href="javascript:history.back()">다시 선택 #1</a>
<br><br>
<a href="ex10_form.jsp">다시 선택 #2</a>
</body>
</html>
