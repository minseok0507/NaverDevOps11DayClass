<%@ page import="com.example.classjsp.data.dto.SawonDto" %>
<%@ page import="com.example.classjsp.data.dao.SawonDao" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 30.
  Time: 오후 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<%
    request.setCharacterEncoding("UTF-8");
%>
    <jsp:useBean id="dto" class="com.example.classjsp.data.dto.SawonDto"/>
    <jsp:useBean id="dao" class="com.example.classjsp.data.dao.SawonDao"/>

    <jsp:setProperty name="dto" property="*"/>
<%
    dao.updateData(dto);

    response.sendRedirect("sawonList.jsp");
%>