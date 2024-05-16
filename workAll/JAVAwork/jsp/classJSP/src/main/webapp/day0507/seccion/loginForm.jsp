<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 7.
  Time: 오전 11:16
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
    String myId = (String) session.getAttribute("myId");
    String saveOk = (String) session.getAttribute("saveOk");
    String sadfdsaf = (String) session.getAttribute("asdfasdff");
    out.println(session.getAttribute("sdf"));
    String id = saveOk.equals("yes")?myId:"";
    String checked = saveOk.equals("yes")?"checked":"";
%>
<body>
<form action="loginAction.jsp" method="post">
    <table class="table table-bordered" style="width: 250px;">
        <caption align="top"><b>회원 로그인</b>
            <label for="save"><input type="checkbox" name="save" id="save" style="margin-left: 50px;" <%=checked%>>아이디저장</label>
        </caption>
        <tr>
            <th width="100" class="table-success">아이디</th>
            <td><input type="text" name="myId" class="form-control" value="<%=id%>"></td>
        </tr>
        <tr>
            <th width="100" class="table-success">비밀번호</th>
            <td><input type="password" name="myPass" class="form-control"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button class="btn btn-outline-danger">회원로그인</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
