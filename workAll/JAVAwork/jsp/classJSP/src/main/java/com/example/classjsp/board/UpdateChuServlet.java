package com.example.classjsp.board;

import com.example.classjsp.data.dao.SimpleBoardDao;
import com.example.classjsp.data.dto.SimpleBoardDto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/updatechu")
public class UpdateChuServlet extends HttpServlet {
    SimpleBoardDao dao=new SimpleBoardDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //num,currentPage 를 읽는다
        int num=Integer.parseInt(request.getParameter("num"));

        dao.updateChu(num);

        int chu = dao.getData(num).getChu();
        String s = "{\"chu\":"+chu+"}";

        request.setAttribute("chu", s);

        RequestDispatcher rd=request.getRequestDispatcher("../day0514/jsonChu.jsp");
        rd.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}