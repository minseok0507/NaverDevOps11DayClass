<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 26.
  Time: 오후 3:16
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
<h5>폼태그 읽기</h5>
<form action="ex09_action.jsp" method="post">
    <table class="table table-bordered" style="width: 400px">
        <tr>
            <th class="table-info" width="100">몸무게</th>
            <td>
                <input type="text" name="weight" class="form-control" required autofocus="autofocus">
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">생년월일</th>
            <td>
                <input type="date" name="birth" class="form-control" value="2020-12-14">
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">색</th>
            <td>
                <label>
                    <input type="color" name="color" value="#ccffff">
                </label>
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">숨김</th>
            <td>
                <label>
                    <input type="hidden" name="hide" value="뭘 보노~">
                </label>
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">말</th>
            <td>
                <textarea name="textarea" id="textarea" cols="30" rows="10" style="width: 100%; height: 100px"></textarea>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <button class="btn btn-outline-success">전송</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
