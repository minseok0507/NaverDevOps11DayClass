package com.example.classjsp.servlet;

import com.example.classjsp.data.dao.ShopDao;
import com.example.classjsp.data.dto.ShopDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/study4")
public class HappyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list1 = Arrays.asList("orange", "green", "pink", "gray", "magenta", "tomato");
        req.setAttribute("list1", list1);

        req.setAttribute("flowers", "장미꽃,안개꽃,다알리아,프리지아,국화,채송화,칸나");

        RequestDispatcher rd = req.getRequestDispatcher("./day0513/test4.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
