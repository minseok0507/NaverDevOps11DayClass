<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 26.
  Time: 오전 10:17
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
<body>
<table class="table table-bordered" style="width: 100%; text-align: center">
    <caption align="top"><b>[구구단]</b></caption>
    <tr>
        <%
            for (int dan = 2; dan <= 9; dan++) {%>
        <td><b><%=dan%>단</b></td>
        <%
            }
        %>
    </tr>
    <%
        for (int dan = 1; dan <= 9; dan++) {
            out.print("<tr>");
            for (int i = 2; i <= 9; i++) {%>

    <td><%=i%>X<%=dan%>=<b style="font-size: 1.3em"><%=i * dan%></b></td>

    <%
            }
            out.print("</tr>");
        }
    %>
</table>

</body>
</html>
