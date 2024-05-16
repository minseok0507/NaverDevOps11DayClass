<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 10.
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="dao" class="com.example.classjsp.data.dao.ShopDao"/>
<jsp:useBean id="dto" class="com.example.classjsp.data.dto.ShopDto"/>
<jsp:setProperty name="dto" property="*"/>

<%
    dao.insertShop(dto);
%>
