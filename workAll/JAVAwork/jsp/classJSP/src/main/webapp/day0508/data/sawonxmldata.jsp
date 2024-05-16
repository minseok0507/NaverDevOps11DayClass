<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 8.
  Time: 오후 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.List" %>
<%@ page import="com.example.classjsp.data.dao.SawonDao" %>
<%@ page import="com.example.classjsp.data.dto.SawonDto" %>

<%
    SawonDao dao = new SawonDao();
    //전체 사원 데이타 가져오기
    List<SawonDto> list = dao.selectAllSawon();
%>
<sawonlist>
    <%
        for (SawonDto dto : list) {%>
    <sawon>
        <name><%=dto.getName() %></name>
        <buseo><%=dto.getBuseo() %></buseo>
        <age><%=dto.getAge() %></age>
        <addr><%=dto.getAddr() %></addr>
        <birthday><%=dto.getBirthday() %></birthday>
        <photo><%=dto.getPhoto() %></photo>
        <gender><%=dto.getGender() %></gender>
    </sawon>
    <%
        }
    %>
</sawonlist>