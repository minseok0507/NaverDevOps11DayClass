<%@ page import="com.example.classjsp.data.dao.SawonDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 1.
  Time: 오전 10:52
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
        SawonDao dao = new SawonDao();

        List< Map<String, String>> list = dao.selectBuseoAnal();


    %>
</head>
<body>
<div style="margin: 30px 100px; width: 250px;">
    <table width="250" class="table-info">
        <caption align="top"><h4><b>우리 회사 성별 분석표</b></h4></caption>
        <tr class="table-danger" align="center">
            <th>성별</th>
            <th>인원 수</th>
            <th>평균 나이</th>
        </tr>
        <%
            for (int i = 0; i < list.size(); i++) {
        %>
        <tr>
            <td><%=list.get(i).get("buseo")%></td>
            <td><%=list.get(i).get("count")%>명</td>
            <td><%=list.get(i).get("age")%>세</td>
        </tr>
        <%
            }
        %>

        <tr>
            <td>
                <button class="btn btn-outline-danger"
                        onclick="history.back()">이전으로</button>
            </td>
        </tr>
    </table>
</div>

</body>
</html>
