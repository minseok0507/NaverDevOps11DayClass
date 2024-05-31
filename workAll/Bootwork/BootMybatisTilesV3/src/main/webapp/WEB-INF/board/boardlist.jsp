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

        table {
        }

        th {
            text-align: center;
        }

        td {
            vertical-align: middle;
        }

    </style>
</head>
<body>
총 ${countMember}개의 글이 있습니다
<c:if test="${sessionScope.myid != null}">
    <button class="btn btn-info" id="write-button" style="float: right">글쓰기</button>
</c:if>
<table class="table">
    <tr>
        <th width="50">번호</th>
        <th width="">제목</th>
        <th width="100">작성일</th>
        <th width="60">작성자</th>
        <th width="60">조회수</th>
        <th width="50">추천</th>
        <c:if test="${sessionScope.myid != null}">
            <th width="50">답글</th>
        </c:if>
    </tr>

    <c:forEach items="${boardDtoList}" var="dto">
        <tr>
            <td>${dto.id}</td>
            <td style="padding-left: calc(${dto.level}00px / 3)"
                onclick="location.href='/board/detail?id=${dto.id}'"
            >${dto.boardTitle}
<%--                <sup style="color: red">[이걸 어떻게 넣냐...]</sup>--%>
            </td>
            <td style="font-size: 10px;"><fmt:formatDate value="${dto.boardDate}" pattern="MM-dd HH:mm"/></td>
            <td>${dto.writeUser}</td>
            <td>${dto.viewCount}</td>
            <td>${dto.recommendCount}</td>
            <c:if test="${sessionScope.myid != null}">
                <td><a href="<c:url value="/board/reply?id=${dto.id}"/>">
                    <button>답글</button>
                </a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<div class="page-nav">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="<c:url value="/board/list?page=${page-1}"/>" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach varStatus="i" end="${maxPage}" begin="1">
                <li class="page-item"><a class="page-link"
                                         href="<c:url value="/board/list?page=${i.count}"/>">${i.count}</a></li>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="<c:url value="/board/list?page=${page+1}"/>" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>


<script>
    writeBtn = document.getElementById("write-button");
    writeBtn.addEventListener("click", () => {
        if (${sessionScope.myid==null}) {
            alert("로그인을 하시오")
        } else {
            location.href = '/board/write'
        }
    })
</script>
</body>
</html>
