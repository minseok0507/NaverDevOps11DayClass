<%@ page import="java.util.List" %>
<%@ page import="com.example.classjsp.data.dto.GuestDto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.classjsp.data.dao.GuestDao" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 9.
  Time: 오후 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //검색 단어 읽기
    String search = request.getParameter("search");
    GuestDao dao = new GuestDao();
    List<GuestDto> list = new ArrayList<GuestDto>();
    if (search == null || search.equals("")) {
        list = dao.selectAll();
    } else {
        list = dao.getSearchGuest(search);
    }

    JSONArray arr = new JSONArray();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    for (GuestDto guest : list) {
        JSONObject obj = new JSONObject();
        obj.put("num", guest.getNum());
        obj.put("nickname", guest.getNickname());
        obj.put("avata", guest.getAvata());
        obj.put("content", guest.getContent());
        obj.put("writeday", dateFormat.format(guest.getWriteday()));

        arr.add(obj);
    }

%>

<%=arr.toString()%>