<%@ page import="com.example.classjsp.data.dao.GuestDao" %>
<%@ page import="com.example.classjsp.data.dto.GuestDto" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 9.
  Time: 오후 4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("UTF-8");

    String nickname = request.getParameter("nickname");
    String content = request.getParameter("content");

    int num = Integer.parseInt(request.getParameter("num"));

    GuestDto guest = new GuestDto();
    guest.setNickname(nickname);
    guest.setContent(content);
    guest.setNum(num);

    GuestDao dao = new GuestDao();
    dao.update(guest);
%>