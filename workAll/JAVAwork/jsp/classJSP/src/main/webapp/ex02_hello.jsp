<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 25.
  Time: 오후 3:33
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
<h5>자바영역 배열 변수 table 출력</h5>
<%
    String[] color = {"red", "orange", "pink", "green", "gray"};
%>
<table class="table table-striped" style="width: 200px">
    <caption align="top"><b>색상 배열 출력</b></caption>
    <tr>
        <th>번호</th>
        <th>색상</th>
    </tr>
    <%
        for (int i = 0; i < color.length; i++) {%>
    <tr>
        <td><%=i + 1%>
        </td>
        <td style="background-color: <%=color[i]%>"><%=color[i]%>
        </td>
    </tr>
    <%}%>
</table>

<hr>

<%
    String name = "신민아";
    String addr = "강남";
    int age = 24;
    String blood = "AB형";
    String photo = "./img/17.jpg";
    String[] hobby = {"자바공부", "스프링공부", "제이쿼리", "게임", "웹툰"};
%>

<table class="table table-bordered" style="width: 400px">
    <tr>
        <td width="200" rowspan="4">
            <img src="<%=photo%>" alt="" width="190">
        </td>
        <td>
            이름
        </td>
        <td>
            <%=name%>
        </td>
    </tr>
    <tr>
        <td>
            주소
        </td>
        <td>
            <%=addr%>
        </td>
    </tr>
    <tr>
        <td>
            나이
        </td>
        <td>
            <%=age%>
        </td>
    </tr>
    <tr>
        <td>
            혈액형
        </td>
        <td>
            <%=blood%>
        </td>
    </tr>

</table>
</body>
</html>
