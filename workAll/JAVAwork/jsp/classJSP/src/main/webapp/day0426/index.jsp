<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 26.
  Time: 오전 11:02
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
<%@ page import="java.io.File" %>
<%@ page import="javax.servlet.ServletContext" %>
<%@ page import="java.util.Arrays" %>
<%
    // 현재 JSP 파일의 상대 경로 가져오기
    String relativeDir = ((ServletContext) pageContext.getServletContext()).getRealPath(request.getServletPath());

    // 상위 디렉토리로 이동
    File dir = new File(relativeDir).getParentFile();

    // 현재 디렉토리의 파일 및 디렉토리 목록 가져오기
    File[] files = dir.listFiles();

    // 파일 및 디렉토리 목록 오름차순 정렬
    Arrays.sort(files);

    // 파일 및 디렉토리 정보 출력하기
    out.println("<h1>day Class</h1>");
    out.println("<ul>");
    for (File file : files) {
        String fileName = file.getName();
        if (fileName.endsWith("jsp")) {%>
<li>
    <a href="<%=fileName%>"><%=fileName%>
    </a>
</li>
<%
        }
    }
    out.println("</ul>");
%>
</body>
</html>
