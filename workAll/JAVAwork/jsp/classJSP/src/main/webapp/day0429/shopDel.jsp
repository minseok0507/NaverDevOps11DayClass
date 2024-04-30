<%@ page import="com.example.classjsp.data.dto.ShopDto" %>
<%@ page import="com.example.classjsp.data.dao.ShopDao" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 29.
  Time: 오후 4:42
  To change this template use File | Settings | File Templates.
--%>


<%
    request.setCharacterEncoding("utf-8");

    Long id = Long.valueOf(request.getParameter("id"));

    ShopDao shopDao = new ShopDao();
    shopDao.delete(id);


    response.sendRedirect("./shoplist.jsp");

%>
