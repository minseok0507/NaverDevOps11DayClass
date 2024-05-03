<%@ page import="com.example.classjsp.data.dao.StudentDao" %>
<%@ page import="com.example.classjsp.data.dto.StudentDto" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 1.
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%
        request.setCharacterEncoding("utf-8");

        StudentDao dao = new StudentDao();
        StudentDto dto = new StudentDto();

        String name = request.getParameter("name");
        String blood = request.getParameter("blood");
        String getLicense = request.getParameter("license");
        boolean license = false;
        if (getLicense != null) {
            license = true;
        }
        int java = Integer.parseInt(request.getParameter("java"));
        int spring = Integer.parseInt(request.getParameter("spring"));
        int html = Integer.parseInt(request.getParameter("html"));

        dto.setName(name);
        dto.setBlood(blood);
        dto.setJava(java);
        dto.setSpring(spring);
        dto.setHtml(html);
        dto.setLicense(license);


        dao.insertStudent(dto);

        response.sendRedirect("studentList.jsp");
    %>