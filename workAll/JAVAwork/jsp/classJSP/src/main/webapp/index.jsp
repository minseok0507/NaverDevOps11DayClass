<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%@ page import="java.io.File" %>
<%@ page import="javax.servlet.ServletContext" %>
<%@ page import="java.util.Arrays" %>
<%
    // 현재 JSP 파일의 상대 경로 가져오기
    String relativeDir = ((ServletContext)pageContext.getServletContext()).getRealPath(request.getServletPath());

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
        if (file.isDirectory() && fileName.startsWith("day")) {%>
        <li>
            <a href="<%=fileName%>"><%=fileName%></a>
        </li>
<%
        }
    }
    out.println("</ul>");
%>


</body>
</html>
