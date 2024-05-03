<%@ page import="com.example.classjsp.data.dao.StudentDao" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 1.
  Time: 오후 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");

    int num = Integer.parseInt(request.getParameter("num"));

    StudentDao dao = new StudentDao();
    dao.deleteStudent(num);

    response.sendRedirect("studentList.jsp");
%>
