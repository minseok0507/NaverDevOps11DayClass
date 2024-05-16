<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 7.
  Time: 오전 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String myId = request.getParameter("myId");
    String myPass = request.getParameter("myPass");
    String save = request.getParameter("save");

    if (myPass.equals("1234")) {
        session.setAttribute("myId", myId);
        session.setAttribute("loginOk", "yes");
        session.setAttribute("saveOk", save==null?"no":"yes");

        session.setMaxInactiveInterval(60 * 60 * 3); //3시간

        response.sendRedirect("sessionMain.jsp");
    } else {%>
<script>
    alert("비밀번호가 안 맞음");
    history.back();
</script>
<%
    }
%>