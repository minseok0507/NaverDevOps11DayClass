<%@ page import="com.example.classjsp.data.dao.GuestDao" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 9.
  Time: 오후 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int num = Integer.parseInt(request.getParameter("num"));

    GuestDao dao = new GuestDao();
    dao.deleteByNum(num);
%>