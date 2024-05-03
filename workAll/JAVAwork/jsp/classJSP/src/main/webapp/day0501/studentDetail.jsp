<%@ page import="com.example.classjsp.data.dao.StudentDao" %>
<%@ page import="com.example.classjsp.data.dto.StudentDto" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 1.
  Time: 오후 2:15
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
        table {
            position: relative;
            left: 50%;
            transform: translate(-50%, 0);
        }
    </style>
    <title>Title</title>
</head>
<%
    request.setCharacterEncoding("utf-8");
    int num = Integer.parseInt(request.getParameter("num"));

    StudentDao dao = new StudentDao();

    StudentDto dto = dao.findByNum(num);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

%>
<body>
<table class="table table-striped" style="width: 700px">
    <caption align="top" style="font-size: 1.5em">학생정보</caption>
    <thead>
    <tr>
        <th scope="col">이름</th>
        <th scope="col">혈액형</th>
        <th scope="col">면허증 유무</th>
        <th scope="col">JAVA</th>
        <th scope="col">Spring</th>
        <th scope="col">HTML</th>
        <th scope="col">평균</th>
        <th scope="col">생성일</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><%=dto.getName()%>
        </td>
        <td><%=dto.getBlood()%>
        </td>
        <td><%
            if (dto.getLicense()) {
                out.print("있음");
            } else {
                out.print("없음");
            }
        %></td>
        <td><%=dto.getJava()%>
        </td>
        <td><%=dto.getSpring()%>
        </td>
        <td><%=dto.getHtml()%>
        </td>
        <td><%=String.format("%.2f", (dto.getJava() + dto.getSpring() + dto.getHtml()) / 3.0)%>
        </td>
        <td><%=sdf.format(dto.getWriteday())%>
        </td>
    </tr>
    </tbody>
    <caption align="top">
        <button class="btn btn-dark" onclick="location.href='studentList.jsp'">학생 목록으로</button>
    </caption>
    <caption align="bottom">
        <button type="button" class="btn btn-danger"
                onclick="deleteStudent(<%=dto.getNum()%>, '<%=dto.getName()%>');">삭제
        </button>
        <button class="btn btn-success"
                onclick="event.stopPropagation();location.href='studentEdit.jsp?num=<%=dto.getNum()%>'">수정</button>
    </caption>
</table>


<script>
    function deleteStudent(num, name) {
        if (confirm(name + ` 학생 정보를 삭제하시겠습니까?`)) {
            fetch('studentActionDelete.jsp', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: new URLSearchParams({
                    num: num
                })
            })
                .then(response => {
                    if (response.ok) {
                        // 삭제 성공
                        alert('학생 정보 삭제 성공')
                        location.href='studentList.jsp';
                    } else {
                        // 삭제 실패
                        alert('학생 정보 삭제에 실패했습니다.');
                    }
                })
                .catch(error => {
                    // 네트워크 오류 등 처리
                    alert('학생 정보 삭제 중 오류가 발생했습니다.');
                });
        }event.stopPropagation();
    }
</script>


</body>
</html>
