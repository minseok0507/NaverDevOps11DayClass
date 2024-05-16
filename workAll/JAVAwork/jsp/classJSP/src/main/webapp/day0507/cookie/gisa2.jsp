<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 7.
  Time: 오전 9:55
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
    boolean findPass = false;
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (name.equals("pass")) {
                findPass = true;
                break;
            }
        }
    }
%>
<body>
<%
    if (findPass) {%>
<pre>
영화계에 큰 획을 그은 배우 故 강수연이 우리 곁을 떠난 지 2년이 흘렀다.

강수연은 지난 2022년 5월 7일 오후 3시께 세상을 떠났다. 향년 55세.

서울 강남구 압구정동 자택에서 뇌출혈 증세로 쓰러진 채 발견된 강수연은 사흘째 의식불명 상태로 병원 치료를 받아오다 끝내 숨을 거뒀다.

당시 ‘원조 월드스타’로 불리며 반세기 넘게 한국영화와 함께한 故 강수연의 갑작스러운 비보에 영화계는 큰 충격과 슬픔에 빠졌다.
</pre>
<%
} else {
%>
<script>
    alert("암호를 입력하시오")
    history.back();
</script>
<%
    }
%>
</body>
</html>
