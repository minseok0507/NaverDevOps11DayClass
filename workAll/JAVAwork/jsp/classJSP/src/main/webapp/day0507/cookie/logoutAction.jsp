<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 7.
  Time: 오전 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("pass")) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
    }

    response.sendRedirect("cookieMain.jsp");
%>
