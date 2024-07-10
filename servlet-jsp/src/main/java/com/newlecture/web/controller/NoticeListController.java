package com.newlecture.web.controller;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //list?f=title&q=a



        String field_ = request.getParameter("f");
        String query_ = request.getParameter("q");

        String field = "title";
        if(field_ != null)
            field = field_;

        String query = "";
        if(query_ != null)
            query = query_;

        NoticeService service = new NoticeService();
        List<Notice> list = service.getNoticeList(field, query, 1);

        request.setAttribute("list", list);

        request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
    }
}
