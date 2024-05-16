<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 7.
  Time: 오전 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String pass = request.getParameter("pass");

    if (pass.equals("1234")) {
        Cookie cookie = new Cookie("pass", "yes");
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 3); //3시간
        response.addCookie(cookie);
        response.sendRedirect("cookieMain.jsp");
    } else {%>
<script>
    alert("암호 틀림");
    history.back();
</script>
<%
    }
%>
