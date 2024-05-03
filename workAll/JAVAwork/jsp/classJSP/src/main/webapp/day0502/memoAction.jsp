<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 2.
  Time: 오전 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="com.example.classjsp.data.dao.MemoDao" %>
<%@ page import="com.example.classjsp.data.dto.MemoDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");

    String savePath = application.getRealPath("./save");
    String file = "";
    String oriFile = "";
    int sizeLimit = 5 * 1024 * 1024;
    System.out.println(savePath);

    MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
    Enumeration files = multi.getFileNames();
    String name = (String) files.nextElement();

    file = multi.getFilesystemName(name);
    oriFile = multi.getOriginalFileName(name);

    String title = multi.getParameter("title");
    String content = multi.getParameter("content");

    System.out.println(title);
    System.out.println(content);

    MemoDao dao = new MemoDao();
    MemoDto dto = new MemoDto();
    dto.setTitle(title);
    dto.setContent(content);

    dto.setUploadPhoto(file);

    dao.insertMeno(dto);
%>

<html>
<head>
    <title>File Upload</title>
</head>
<body>
<h2>파일 업로드 성공</h2><br/>
파일 저장 위치 : <%= savePath%><br/>
파일 저장 이름 : <%= file%><br/>
파일 원본 이름 : <%= oriFile%> <br>
<button onclick="location.href='memoList.jsp'">리스트</button>

</body>
</html>