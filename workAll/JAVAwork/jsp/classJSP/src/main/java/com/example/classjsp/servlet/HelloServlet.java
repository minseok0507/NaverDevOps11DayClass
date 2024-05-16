package com.example.classjsp.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/study1")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("msg", "Hello World");
        req.setAttribute("today", new Date());

        req.setAttribute("num1", 8);
        req.setAttribute("num2", 5);



        //test1.jsp 포워드(url 안바뀜, response, request 그대로 전달)
        RequestDispatcher rd = req.getRequestDispatcher("./day0513/test1.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
