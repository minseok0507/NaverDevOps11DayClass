<%@ page import="com.example.classjsp.data.dto.GuestDto" %>
<%@ page import="com.example.classjsp.data.dao.GuestDao" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 9.
  Time: 오후 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");

    GuestDao guestDao = new GuestDao();
    GuestDto guestDto = new GuestDto();

    guestDto.setNickname(request.getParameter("nickname"));
    guestDto.setAvata(request.getParameter("avata"));
    guestDto.setContent(request.getParameter("content"));

    guestDao.insertMeno(guestDto);
%>
