package com.example.classjsp.board;

import com.example.classjsp.data.dao.SimpleBoardDao;
import com.example.classjsp.data.dto.SimpleBoardDto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/update")
public class UpdateServlet extends HttpServlet {

    SimpleBoardDao simpleBoardDao = new SimpleBoardDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int num = Integer.parseInt(request.getParameter("num"));
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));

        SimpleBoardDto dto=new SimpleBoardDto();

        dto.setNum(num);
        dto.setWriter(request.getParameter("writer"));
        dto.setSubject(request.getParameter("subject"));
        dto.setAvata(request.getParameter("avata"));
        dto.setContent(request.getParameter("content"));

        simpleBoardDao.updateBoard(dto);

        response.sendRedirect("./detail?num="+num+"&currentPage="+currentPage);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}