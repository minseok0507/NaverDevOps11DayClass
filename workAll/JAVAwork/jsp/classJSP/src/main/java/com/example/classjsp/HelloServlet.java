package com.example.classjsp;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        Connection conn=null;

        try{
            String jdbcUrl = "jdbc:mysql://database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com/bitcamp";
            String dbId = "admin";
            String dbPass = "y.TEW7tfi3#4hnZ";

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
            out.println("yes connected");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}