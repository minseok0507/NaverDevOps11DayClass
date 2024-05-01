<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 30.
  Time: 오전 11:35
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
    
    
%>
<body>
<jsp:useBean id="dto" class="com.example.classjsp.data.dto.SawonDto"/>
<jsp:useBean id="dao" class="com.example.classjsp.data.dao.SawonDao"/>

<jsp:setProperty name="dto" property="*"/>

<%
    dao.insertSawon(dto);

    response.sendRedirect("sawonList.jsp");
%>


</body>
</html>
