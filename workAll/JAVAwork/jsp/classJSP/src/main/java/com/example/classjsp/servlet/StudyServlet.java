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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/study3")
public class StudyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list1 = Arrays.asList("orange", "green", "pink", "gray", "magenta", "tomato");
        req.setAttribute("list1", list1);

        ShopDao shopDao = new ShopDao();
        List<ShopDto> shopDtoList = shopDao.selectAll();
        req.setAttribute("shopDtoList", shopDtoList);
        for (ShopDto shopDto : shopDtoList) {
            shopDto.setPhoto(shopDto.getPhoto().replace("..","."));
        }

        RequestDispatcher rd = req.getRequestDispatcher("./day0513/test3.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
