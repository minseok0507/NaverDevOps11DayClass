<%@ page import="com.example.classjsp.data.dao.SawonDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.classjsp.data.dto.SawonDto" %><%--
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

        div.list {
            float: left;
            margin: 10px;
            width: 150px;
            height: 200px;
            border: 1px solid gray;
            box-shadow: 5px 5px 5px black;
            border-radius: 20px;
            padding: 10px;
            text-align: center;
        }

        div.list img {
            border-radius: 20px;
            width: 100px;
            height: 110px;
            margin-bottom: 10px;
        }
    </style>
    <title>Title</title>
</head>
<%
    SawonDao dao = new SawonDao();
    List<SawonDto> list = dao.selectAllSawon();

%>
<body>
<div style="margin: 20px; width: 500px;">
    <div class="input-group">
        <h5 class="alert alert-danger" style="width: 400px">총 <%=list.size()%>명의 사원이 있습니다.</h5>
        <button class="btn btn-sm btn-info"
                onclick="location.href='sawonForm.jsp'"
                style="margin-left: 10px; height: 50px">사원추가
        </button>
    </div>
    <div>
        <button class="btn btn-success" style="width: 170px"
                onclick="location.href='sawonAgeAnal.jsp'">
            성별 분석표
        </button>

        <button class="btn btn-success" style="width: 170px"
                onclick="location.href='sawonBuseoAnal.jsp'">
            부서 분석표
        </button>
    </div>
    <%
        for (int i = 0; i < list.size(); i++) {
    %>
    <div class="list">
        <%
            String photoUrl;
            if (list.get(i).getPhoto() == null || list.get(i).getPhoto().isEmpty()) {
                photoUrl = "https://cdn-icons-png.flaticon.com/512/6522/6522516.png";
            } else {
                photoUrl = list.get(i).getPhoto();
            }
        %>
        <img src="<%=photoUrl%>" alt=""><br>
        <b><%=list.get(i).getName()%> 사원</b><br>
        <button class="btn btn-sm btn-outline-danger"
                onclick="location.href='sawonDetail.jsp?num=<%=list.get(i).getNum()%>'">
            상세보기
        </button>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
