<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 1.
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dao" class="com.example.classjsp.data.dao.StudentDao"/>
<jsp:useBean id="dto" class="com.example.classjsp.data.dto.StudentDto"/>

<%
    request.setCharacterEncoding("utf-8");

    int num = Integer.parseInt(request.getParameter("num"));
    int java = Integer.parseInt(request.getParameter("java"));
    int spring = Integer.parseInt(request.getParameter("spring"));
    int html = Integer.parseInt(request.getParameter("html"));
    String name = request.getParameter("name");
    String blood = request.getParameter("blood");
    String stringLic = request.getParameter("license");
    boolean license = false;
    if (stringLic != null && stringLic.equals("on")){
        license = true;
    }

    dto.setName(name);
    dto.setBlood(blood);
    dto.setNum(num);
    dto.setJava(java);
    dto.setSpring(spring);
    dto.setHtml(html);
    dto.setLicense(license);

    dao.updateStudent(dto);

    response.sendRedirect("studentList.jsp");
%>