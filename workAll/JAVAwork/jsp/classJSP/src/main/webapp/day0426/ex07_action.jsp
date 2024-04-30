<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 26.
  Time: 오후 12:36
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
    //post로 보낸 데이터는 엔코딩해줘야됨(영어는 안깨짐;;)
    request.setCharacterEncoding("UTF-8");

    String home = request.getParameter("home");
    String email = request.getParameter("email");
    String[] hobby = request.getParameterValues("hobby");
%>
<body>
    <h5>나의 주거지 : <%=home%></h5>
    <h5>나의 email : <%=email%></h5>
    <h5>나의 취미 : <%
        if (hobby == null || hobby.length == 0) {
            out.print("취미가 없음");
        }else {
            for (int i = 0; i < hobby.length; i++) {
                out.print(hobby[i]);
            }
        }
    %></h5>
</body>
</html>
