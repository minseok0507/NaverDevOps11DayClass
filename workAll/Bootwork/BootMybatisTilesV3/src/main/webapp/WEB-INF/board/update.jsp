<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 28.
  Time: 오후 2:05
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
        form{
            width: 100%;
            padding: 20px;
        }
        form > * {
            width: 100%;
            padding: 3px;
            margin-top: 5px;
        }
    </style>
    <title>Title</title>
</head>
<body>
<form action="<c:url value="/board/update/action"/>" method="post">
    <input type="hidden" id="id" name="id" value="${id}">
    <input type="text" id="title" name="title" required placeholder="제목" value="${dto.boardTitle}">
    <textarea name="content" id="content" cols="30" rows="10" required placeholder="내용">${dto.boardContent}</textarea>
    <button>작성</button>
</form>
</body>
</html>
