<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 29.
  Time: 오전 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link rel="stylesheet" href="list.css">
    <style>
    </style>
    <title>list</title>

</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.classjsp.data.dto.itemDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
    Connection conn = null;
    List<itemDto> itemDtos = new ArrayList<itemDto>();
    String jdbcUrl = "jdbc:mysql://database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com/shop";
    String dbId = "admin";
    String dbPass = "y.TEW7tfi3#4hnZ";
    Class.forName("com.mysql.jdbc.Driver");
    try {
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);

        String sql = "SELECT * FROM item";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);


        while (rs.next()) {
            itemDto item = new itemDto();
            item.setId(rs.getInt("id"));
            item.setPrice(rs.getString("price"));
            item.setTitle(rs.getString("title"));
            item.setUrl(rs.getString("url"));
            item.setWrite_user_id(rs.getString("write_user_id"));

            itemDtos.add(item);
        }


    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<form action="/search" method="POST">
    <input type="text" name="searchText" style="display:inline">
    <button>검색</button>
</form>


<h1>상품페이지</h1>

<%
    for (int i = 0; i < itemDtos.size(); i++) {
        out.print("");
        out.print("<div class=\"card\">");
        out.print("<a>");
        out.print("<img src=\"" + itemDtos.get(i).getUrl() + "\" width=\"300px\">");
        out.print("<div>");
        out.print("<h4>" + itemDtos.get(i).getTitle() + "</h4>");
        out.print("<p>" + itemDtos.get(i).getPrice() + "</p>");
        out.print("</div>");
        out.print("</a>");
        out.print("<a>수정</a>");
        out.print("<button class=\"btn\">삭제");
        out.print("</button>");
        out.print("</div>");

    }
%>


<%--<ul class="pagenum-list">--%>
<%--    <li>--%>
<%--        <span class="total_page" th:text="${ total_page }"></span>--%>

<%--        <a th:href="@{  '/list/' + ${page_num - 1} }"><</a>--%>

<%--        <a th:each="num : ${#numbers.sequence(1, total_page)}"--%>
<%--           th:href="@{  '/list/' + ${num} }"--%>
<%--           th:text="${num}"></a>--%>

<%--        <a th:href="@{  '/list/' + ${page_num + 1} }">></a>--%>
<%--    </li>--%>
<%--</ul>--%>

<script src="/pagenation.js"></script>
</body>
</html>
