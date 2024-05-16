package com.example.classjsp.board;

import com.example.classjsp.data.dto.SimpleBoardDto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/updateform")
public class UpdateFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));

        SimpleBoardDto boardDto = new SimpleBoardDto();

        request.setAttribute("dto", boardDto);
        request.setAttribute("currentPage", currentPage);
        
        RequestDispatcher rd=request.getRequestDispatcher("../day0514/updateform.jsp");
        rd.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}