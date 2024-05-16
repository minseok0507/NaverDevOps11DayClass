<%@ page import="com.example.classjsp.data.dao.ShopDao" %>
<%@ page import="com.example.classjsp.data.dto.ShopDto" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 10.
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));

    ShopDao dao = new ShopDao();

    ShopDto dto = dao.selectById((long) id);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    JSONObject object = new JSONObject();
    object.put("id", dto.getId());
    object.put("name", dto.getName());
    object.put("price", dto.getPrice());
    object.put("count", dto.getCount());
    object.put("color", dto.getColor());
    object.put("photo", dto.getPhoto());
    object.put("writeday", sdf.format(dto.getWriteday()));
%>

<%=object.toString()%>