<%@ page import="com.example.classjsp.data.dao.SawonDao" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 30.
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    request.setCharacterEncoding("utf-8");

    int num = Integer.parseInt(request.getParameter("num"));

    SawonDao sawonDao = new SawonDao();
    sawonDao.deleteData(num);

    response.sendRedirect("sawonList.jsp");
%>