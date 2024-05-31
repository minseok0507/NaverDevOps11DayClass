<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
   <style>
       body *{
           font-family: 'Jua';
       }

       .member-data > td{
           vertical-align: middle;
       }
   </style>
</head>
<body>
<c:set var="root" value="<%=request.getContextPath()%>"/>
<c:set var="stPasth" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-56/photocommon/" />
<h3 class="alert alert-success">
	총 ${totalCount}명의 회원이 있습니다
</h3>
<div style="width: 100%;">
    <table style="width: 100%" class="table">
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>아이디</th>
            <th>핸드폰</th>
            <th>상세보기</th>
        </tr>
        <c:forEach items="${memberList}" var="member" varStatus="i">
            <tr class="member-data">
                <td>${member.num}</td>
                <td><img src="/upload-img/${member.photo}" alt="" width="20" style="border-radius: 100%;"> ${member.name}</td>
                <td>${member.myid}</td>
                <td>${member.hp}</td>
                <td>
                    <button class="btn btn-sm btn-info" onclick="location.href='${root}/member/detail?num=${member.num}'">Detail</button>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>








