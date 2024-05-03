<%@ page import="com.example.classjsp.data.dao.MemoDao" %>
<%@ page import="com.example.classjsp.data.dto.MemoDto" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 2.
  Time: 오전 10:54
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
    request.setCharacterEncoding("utf-8");

    int num = Integer.parseInt(request.getParameter("num"));

    MemoDao memoDao = new MemoDao();
    MemoDto dto = memoDao.selectByNum(num);
%>
<body>
<h3><%=dto.getTitle()%></h3>
<img src="../save/<%=dto.getUploadPhoto()%>" alt="사진"> : <%=dto.getUploadPhoto()%> <br>
<p><%=dto.getContent()%></p>

</body>
</html>
