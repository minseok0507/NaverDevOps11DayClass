<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 28.
  Time: 오후 3:17
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
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
    <title>Title</title>
</head>
<body>
<%@ page import="java.sql.*"%>

<% request.setCharacterEncoding("utf-8");%>

<%
    String idt = request.getParameter("idt");
    String passwd= request.getParameter("passwd");
    String name = request.getParameter("name");
    String addr = request.getParameter("addr");
    String birth_date = request.getParameter("birth_date");
    String sex = request.getParameter("sex");
    Timestamp register=new Timestamp(System.currentTimeMillis());

    Connection conn=null;
    PreparedStatement pstmt=null;
    String str="";
    try{
        String jdbcUrl = "jdbc:mysql://database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com/bitcamp";
        String dbId = "admin";
        String dbPass = "y.TEW7tfi3#4hnZ";

        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(jdbcUrl,dbId ,dbPass );

        String sql= "insert into member values (?,?,?,?,?,?,?)";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,idt);
        pstmt.setString(2,passwd);
        pstmt.setString(3,name);
        pstmt.setString(4,addr);
        pstmt.setString(5,birth_date);
        pstmt.setString(6,sex);
        pstmt.setTimestamp(7,register);
        pstmt.executeUpdate();

        out.println("member 테이블에 새로운 레코드를 추가했습니다.");

    }catch(Exception e){
        e.printStackTrace();
        out.println("member 테이블에 새로운 레코드를 추가에 실패했습니다");
    }finally{
        if(pstmt != null)
            try{pstmt.close();}catch(SQLException sqle){}
        if(conn != null)
            try{conn.close();}catch(SQLException sqle){}
    }
%>

</body>
</html>
