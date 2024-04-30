<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 26.
  Time: 오후 2:17
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
    request.setCharacterEncoding("UTF-8");

    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    String gender = request.getParameter("gender");
    String lic = request.getParameter("lic");
    String blood = request.getParameter("blood");
    String[] tec = request.getParameterValues("tec");

    lic = lic == null ? "없음" : "있음";
%>
<body>
<div>
    이름 : <%=name%> <br>
    비번 : <%=pass%> <br>
    성별 : <%=gender%> <br>
    운전면허 : <%=lic%> <br>
    혈액형 : <%=blood%> <br>
    기술 : <%
    if (tec == null || tec.length == 0) {
        out.print("없음");
    }else {
        for (int i = 0; i < tec.length; i++) {
            out.print(tec[i] + " ");
        }
    }



%>
</div>

</body>
</html>
