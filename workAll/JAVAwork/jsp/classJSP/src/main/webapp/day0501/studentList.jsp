<%@ page import="com.example.classjsp.data.dto.StudentDto" %>
<%@ page import="com.example.classjsp.data.dao.StudentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 1.
  Time: 오전 11:42
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

        th {
            text-align: center;
        }

        table {
            position: relative;
            left: 50%;
            transform: translate(-50%, 0);
        }
    </style>
    <title>Title</title>

    <%
        StudentDao dao = new StudentDao();
        List<StudentDto> list = dao.findAll();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    %>
</head>
<body>
<table class="table table-striped" style="width: 500px">
    <caption align="top" style="font-size: 1.5em">학생정보</caption>
    <thead>
    <tr>
        <th scope="col">삭제</th>
        <th scope="col">이름</th>
<%--        <th scope="col">혈액형</th>--%>
<%--        <th scope="col">면허증 유무</th>--%>
<%--        <th scope="col">JAVA</th>--%>
<%--        <th scope="col">Spring</th>--%>
<%--        <th scope="col">HTML</th>--%>
<%--        <th scope="col">평균</th>--%>
        <th scope="col">생성일</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (int i = 0; i < list.size(); i++) {
    %>
    <tr onclick="location.href='studentDetail.jsp?num=<%=list.get(i).getNum()%>'" class="align-middle">
        <th scope="row">
            <button type="button" class="btn btn-danger" style="width: 30px; height: 30px; padding: 0;"
                    onclick="deleteStudent(<%=list.get(i).getNum()%>, '<%=list.get(i).getName()%>');">x
            </button>
        </th>
        <td><%=list.get(i).getName()%>
        </td>
<%--        <td><%=list.get(i).getBlood()%>--%>
<%--        </td>--%>
<%--        <td><%--%>
<%--            if (list.get(i).getLicense()) {--%>
<%--                out.print("있음");--%>
<%--            } else {--%>
<%--                out.print("없음");--%>
<%--            }--%>
<%--        %></td>--%>
<%--        <td><%=list.get(i).getJava()%>--%>
<%--        </td>--%>
<%--        <td><%=list.get(i).getSpring()%>--%>
<%--        </td>--%>
<%--        <td><%=list.get(i).getHtml()%>--%>
<%--        </td>--%>
<%--        <td><%=String.format("%.2f", (list.get(i).getJava() + list.get(i).getSpring() + list.get(i).getHtml()) / 3.0)%>--%>
<%--        </td>--%>
        <td><%=sdf.format(list.get(i).getWriteday())%>
        </td>
        <td>
            <button class="btn btn-success"
            onclick="event.stopPropagation();location.href='studentEdit.jsp?num=<%=list.get(i).getNum()%>'">수정</button>
        </td>
    </tr>
    <%
        }
    %>

    </tbody>
    <caption align="bottom">
        <button class="btn btn-dark" onclick="location.href='studentForm.jsp'">학생 추가</button>
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
                        location.reload();
                        alert('학생 정보 삭제 성공')
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
