<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
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
        ul{
            list-style: none;
            display: flex;
            justify-content: space-around;
        }
        ul li{
            float: left;
            width: 100px;
            text-align: center;
            font-size: 1.3em;
        }
        ul li:hover{
            text-shadow: 2px 2px 2px gray;
        }

    </style>
</head>
<body>
<c:set var="root" value="<%=request.getContextPath()%>"/>
<ul>
    <a href="${root}/"><li>Home</li></a>
    <a href="${root}/member/form"><li>회원가입</li></a>
    <a href="${root}/member/list"><li>회원목록</li></a>
    <a href="${root}/board/list"><li>게시판</li></a>
    <a href="${root}/guest/list"><li>방명록</li></a>
</ul>

</body>
</html>



















