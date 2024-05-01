<%@ page import="com.example.classjsp.data.dao.SawonDao" %>
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
            position: relative;
            font-family: 'Jua';
        }

        .container {
            width: 400px;
            position: absolute;
            top: 30%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
    </style>
    <title>Title</title>
    <%
        request.setCharacterEncoding("utf-8");

        int num = Integer.parseInt(request.getParameter("num"));

        SawonDao sawonDao = new SawonDao();
        SawonDto isSawon = sawonDao.getData(num);

    %>
</head>
<body>
<div class="container">
    <table>
        <caption align="top">회사 사원</caption>
        <tr>
            <td rowspan="6" width="170" align="center">
                <%
                    String photoUrl;
                    if (isSawon.getPhoto() == null || isSawon.getPhoto().isEmpty()) {
                        photoUrl = "https://cdn-icons-png.flaticon.com/512/6522/6522516.png";
                    } else {
                        photoUrl = isSawon.getPhoto();
                    }
                %>
                <img src="<%=photoUrl%>" alt="" width="150" height="150"><br>
            </td>
            <td width="70">이름</td>
            <td width="160"><%=isSawon.getName()%></td>
        </tr>
        <tr>
            <td>부서</td>
            <td><%=isSawon.getBuseo()%></td>
        </tr>
        <tr>
            <td>나이</td>
            <td><%=isSawon.getAge()%></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><%=isSawon.getAddr()%></td>
        </tr>
        <tr>
            <td>성별</td>
            <td><%=isSawon.getGender()%></td>
        </tr>
        <tr>
            <td>생년월일</td>
            <td><%=isSawon.getBirthday()%></td>
        </tr>
        <tr>
            <td colspan="3" align="center">
                <button
                onclick="location.href='sawonForm.jsp'">추가</button>

                <button
                onclick="location.href='sawonList.jsp'">목록</button>

                <button
                onclick="location.href='sawonEdit.jsp?num=<%=isSawon.getNum()%>'">수정</button>

                <button onclick="confirmDelete('<%=isSawon.getName()%>', '<%=isSawon.getNum()%>')">삭제</button>

                <script>
                    function confirmDelete(name, num) {
                        if (confirm(`<%=isSawon.getName()%> 사원정보을 삭제하겠습니까?`)) {
                            location.href = `sawonActionDelete.jsp?num=<%=isSawon.getNum()%>`;
                        }
                    }
                </script>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
