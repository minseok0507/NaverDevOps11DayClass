<%@ page import="com.example.classjsp.data.dao.ShopDao" %>
<%@ page import="com.example.classjsp.data.dto.ShopDto" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 29.
  Time: 오후 3:37
  To change this template use File | Settings | File Templates.
--%>

<%
    request.setCharacterEncoding("utf-8");

    Long id = Long.valueOf(request.getParameter("id"));
    String name = request.getParameter("name");
    int price = Integer.parseInt(request.getParameter("price"));
    int count = Integer.parseInt(request.getParameter("count"));
    String color = request.getParameter("color");
    String photo = request.getParameter("photo");

    ShopDto dto = new ShopDto(name, price, count, color, photo);
    dto.setId(id);

    ShopDao shopDao = new ShopDao();
    shopDao.update(dto);
    
    response.sendRedirect("./shopDetail.jsp?id=" + id);

%>