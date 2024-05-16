package com.example.classjsp.servlet;

import com.example.classjsp.data.dao.SawonDao;
import com.example.classjsp.data.dto.SawonDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bitcamp/sawon")
public class SawonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SawonDao sawonDao = new SawonDao();
        List<SawonDto> list = sawonDao.selectAllSawon();

        req.setAttribute("list", list);

        RequestDispatcher rd = req.getRequestDispatcher("/day0513/sawonList.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        SawonDao sawonDao = new SawonDao();
        String search = req.getParameter("search");
        List<SawonDto> list = null;
        if (search == null || search.isEmpty()) {
            list = sawonDao.selectAllSawon();
        } else {
            list = sawonDao.findAllSawonByBuseo(search);
        }

        req.setAttribute("list", list);

        RequestDispatcher rd = req.getRequestDispatcher("/day0513/sawonList.jsp");
        rd.forward(req, resp);
    }
}
