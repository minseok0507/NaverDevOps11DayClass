<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 25.
  Time: 오후 2:37
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
<h3>html 주석,jsp 주석</h3>
<!--html 주석  <%=new Date()%>-->
<%--jsp 주석 <%=new Date()%>--%>


<h5>선언문 변수는 어디든 출력가능</h5>
<h5>이름 : <%=name%></h5>
<h5>나이 : <%=age%></h5>


<%! //선언문
    //서블릿으로 변환시 멤버변수
    String name = "민석잉";
    int age = 30;
%>

<h5>이름2 : <%=name%></h5>
<h5>나이2 : <%=age%></h5>

<%--<h5>주소 : <%=addr%></h5>--%>

<%
    //스크립트릿 scriptlet
    //자바 영역: 서블릿 변환시 특정 메소드 지역변수로 선언
    String addr = "일산";
    out.println("<h6 class=\"alert alert-danger\"> out.println(\"주소 :" + addr + "\")" + "</h6>");
%>



</body>
</html>
