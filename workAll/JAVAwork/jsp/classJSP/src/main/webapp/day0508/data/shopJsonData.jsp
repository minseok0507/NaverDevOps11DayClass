<%@ page import="com.example.classjsp.data.dao.ShopDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.classjsp.data.dto.ShopDto" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 8.
  Time: 오후 3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ShopDao dao = new ShopDao();
    List<ShopDto> list = dao.selectAll();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    JSONArray jsonArray = new JSONArray();
    for (ShopDto shop : list) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("idx", shop.getId());
        jsonObject.put("sname", shop.getName());
        jsonObject.put("sprice", shop.getPrice());
        jsonObject.put("scount", shop.getPrice());
        jsonObject.put("scolor", shop.getPrice());
        jsonObject.put("sphoto", shop.getPrice());
        jsonObject.put("writeday", sdf.format(shop.getWriteday()));


        jsonArray.add(jsonObject);
    }


%>
<%=jsonArray.toString()%>
