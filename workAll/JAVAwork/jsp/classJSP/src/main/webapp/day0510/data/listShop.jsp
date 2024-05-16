<%@ page import="com.example.classjsp.data.dao.ShopDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.classjsp.data.dto.ShopDto" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 10.
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int idx = Integer.parseInt(request.getParameter("idx"));

    ShopDao dao = new ShopDao();
    List<ShopDto> list = dao.getShopDataAll(idx);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    JSONArray json = new JSONArray();
    for (ShopDto shop : list) {
        JSONObject obj = new JSONObject();
        obj.put("id", shop.getId());
        obj.put("name", shop.getName());
        obj.put("price", shop.getPrice());
        obj.put("count", shop.getCount());
        obj.put("color", shop.getColor());
        obj.put("photo", shop.getPhoto());
        obj.put("writeday", sdf.format(shop.getWriteday()));

        json.add(obj);
    }
%>

<%=json.toString()%>
