<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 1.
  Time: 오전 11:59
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
        span{
            font-size: 0.9em;
        }
    </style>
    <title>Title</title>
</head>
<body>
<div style="margin: 20px; width: 400px;">
    <form action="studentActionInsert.jsp" method="post">
        <table class="table table-bordered">
            <caption align="top"><h5 class="alert alert-warning">학생정보 추가</h5></caption>

            <tr>
                <th width="100" class="table-secondary">이름</th>
                <td>
                    <input type="text" name="name" class="form-control" required autofocus>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-secondary">혈액형</th>
                <td>
                    <select name="blood" id="blood" class="form-select">
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="AB">AB</option>
                        <option value="O">O</option>
                    </select>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-secondary">면허증</th>
                <td>
                    <input type="checkbox" name="license" id="license" class="form-check-input"><label for="license">있음 체크</label>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-secondary">점수 입력</th>
                <td>
                    <span>JAVA</span><input type="number" id="java" name="java" class="form-control"><br>
                    <span>Spring</span><input type="number" id="spring" name="spring" class="form-control"><br>
                    <span>HTML</span><input type="number" id="html" name="html" class="form-control"><br>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-primary" style="width: 100px"
                    onclick="location.href='studentActionInsert.jsp'">전송</button>
                </td>
            </tr>


        </table>
    </form>
</div>

</body>
</html>
