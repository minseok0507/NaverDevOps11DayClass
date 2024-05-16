<%@ page import="com.example.classjsp.data.dao.GuestDao" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="com.example.classjsp.data.dto.GuestDto" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 9.
  Time: 오후 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int num = Integer.parseInt(request.getParameter("num"));

    GuestDao dao = new GuestDao();
    GuestDto guest = dao.selectByNum(num);

    JSONObject obj = new JSONObject();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    obj.put("num", guest.getNum());
    obj.put("nickname", guest.getNickname());
    obj.put("avata", guest.getAvata());
    obj.put("content", guest.getContent());
    obj.put("writeday", dateFormat.format(guest.getWriteday()));
%>

<%=obj.toString()%>