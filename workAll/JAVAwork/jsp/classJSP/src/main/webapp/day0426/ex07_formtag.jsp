<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 26.
  Time: 오후 12:35
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
<h5>다양한 폼태그 읽기</h5>
<form action="ex07_action.jsp" method="post">
    <h5>주거지역</h5>
    <label>
        <input type="radio" name="home" value="서울">서울
    </label>
    <label>
        <input type="radio" name="home" value="경기">경기
    </label>
    <label>
        <input type="radio" name="home" value="제주">제주
    </label>
    <label>
        <input type="radio" name="home" value="부산">부산
    </label>
    <br><br>
    이메일 : <input type="email" name="email" required>
    <br><br>
    <h5>취미 선택</h5>
    <label>
        <input type="checkbox" name="hobby" value="게임">게임
    </label>
    <label>
        <input type="checkbox" name="hobby" value="낚시">낚시
    </label>
    <label>
        <input type="checkbox" name="hobby" value="여행">여행
    </label>
    <label>
        <input type="checkbox" name="hobby" value="먹방">먹방
    </label>

    <br><br>
    <button>서버 전송</button>
</form>
</body>
</html>
