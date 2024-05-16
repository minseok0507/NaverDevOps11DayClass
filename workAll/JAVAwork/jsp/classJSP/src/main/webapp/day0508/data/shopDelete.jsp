<%@ page import="com.example.classjsp.data.dao.ShopDao" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 9.
  Time: 오전 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int idx = Integer.parseInt(request.getParameter("shopidx"));
    ShopDao dao = new ShopDao();
    dao.delete((long) idx);
%>