<%@ page import="com.example.classjsp.data.dao.ShopDao" %>
<%@ page import="com.example.classjsp.data.dto.ShopDto" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 29.
  Time: 오전 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int count = Integer.parseInt(request.getParameter("count"));
        String color = request.getParameter("color");
        String photo = request.getParameter("photo");

        ShopDao dao = new ShopDao();
        ShopDto dto = new ShopDto(name, price, count, color, photo);


        dao.insertShop(dto);

        response.sendRedirect("shoplist.jsp");

    %>