<%@ page import="com.example.classjsp.data.dao.StudentDao" %>
<%@ page import="com.example.classjsp.data.dto.StudentDto" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 1.
  Time: 오후 3:21
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
        request.setCharacterEncoding("utf-8");

        StudentDao dao = new StudentDao();
        int num = Integer.parseInt(request.getParameter("num"));
        StudentDto dto = dao.findByNum(num);
    %>
</head>
<body>
<div style="margin: 20px; width: 400px;">
    <form action="studentActionUpdate.jsp" method="post">
        <table class="table table-bordered">
            <caption align="top"><h5 class="alert alert-warning">학생정보 수정</h5></caption>

            <tr>
                <th width="100" class="table-secondary">이름</th>
                <td>
                    <input type="text" name="name" class="form-control" required autofocus value="<%=dto.getName()%>">
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
                    <script>
                        let selBlood = document.getElementById("blood");
                        var bloodArr = selBlood.options;
                        var bloodVal = "<%=dto.getBlood()%>";
                        for (let option of bloodArr) {
                            if (option.value === bloodVal) {
                                selBlood.selectedIndex = option.index;
                                break;
                            }
                        }
                    </script>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-secondary">면허증</th>
                <td>
                    <input type="checkbox" name="license" id="license" class="form-check-input"><label for="license">있음
                    체크</label>
                    <script>
                        let licCB = document.getElementById("license");
                        if (<%=dto.getLicense()%>) licCB.checked = true;
                    </script>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-secondary">점수 입력</th>
                <td>
                    <span>JAVA</span><input type="number" id="java" name="java" class="form-control" value="<%=dto.getJava()%>"><br>
                    <span>Spring</span><input type="number" id="spring" name="spring" class="form-control" value="<%=dto.getSpring()%>"><br>
                    <span>HTML</span><input type="number" id="html" name="html" class="form-control" value="<%=dto.getHtml()%>"><br>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="hidden" name="num" id="num" value="<%=dto.getNum()%>">
                    <button class="btn btn-primary" style="width: 100px"
                            onclick="location.href='studentActionUpdate.jsp'">전송
                    </button>
                </td>
            </tr>


        </table>
    </form>
</div>

</body>
</html>
