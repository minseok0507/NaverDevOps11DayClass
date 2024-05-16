<%@ page import="com.example.classjsp.data.dao.ShopDao" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 10.
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));

    ShopDao shopDao = new ShopDao();

    shopDao.delete((long) id);
%>