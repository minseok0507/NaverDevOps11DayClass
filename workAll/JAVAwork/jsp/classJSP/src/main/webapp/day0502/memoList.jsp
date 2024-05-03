<%@ page import="com.example.classjsp.data.dao.MemoDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.classjsp.data.dto.MemoDto" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 2.
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
</head>
<%
    MemoDao dao = new MemoDao();
    List<MemoDto> list = dao.selectAll();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

%>
<body>
<div style="margin: 10px; width: 500px;">
    <table class="table table-striped">
        <caption align="top">
            <h5><b>총 <%=list.size()%>개의 메모가 있음</b></h5>
            <button class="btn btn-success btn-sm"
                    style="float: right;" onclick="location.href='memoForm.jsp'">메모추가
            </button>
        </caption>
        <tr>
            <th width="60">번호</th>
            <th width="300">제목</th>
            <th>작성일</th>
        </tr>

        <%
            for (int i = 0; i < list.size(); i++) {
        %>
        <tr>
            <td><%=list.get(i).getNum() + 1%>
            </td>
            <td>
                <a href="memoDetail.jsp?num=<%=list.get(i).getNum()%>"><%=list.get(i).getTitle()%>
                </a>
            </td>
            <td><%=sdf.format(list.get(i).getWriteDay())%>
            </td>
        </tr>
        <%
            }
        %>


    </table>
</div>

</body>
</html>
