<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 7.
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
        img.photo{
            width: 100px;
            height: 120px;
            border: 1px solid gray;
            margin: 10px;
            border-radius: 10px;
        }
    </style>
    <title>Title</title>
</head>
<%
    String loginOk = (String) session.getAttribute("loginOk");
    String myId = (String) session.getAttribute("myId");

%>
<body>
<%
    if (loginOk == null) {%>
<script>
    alert("로그인 먼저 하시오")
    location.href = 'sessionMain.jsp';
</script>
<%
} else {%>
<h5>
    <b><%=myId%> 로그인 중</b>
    <button class="btn btn-sm btn-danger" style="margin-left: 100px;"
            onclick="location.href='logoutAction.jsp'">로그아웃
    </button>
</h5>
<h3><b>Shop 상품들</b></h3>
<hr>
<script>
    for (let i = 1; i <= 34; i++) {
        let s = "../../img/shop/" + i + ".jpg";
        document.write("<img src=\"" + s + "\" class=\"photo\">")
    }
</script>

<%
    }
%>
</body>
</html>
