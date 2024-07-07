package com.newlecture.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hi")
public class Nana extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        int cnt = 100;
        String cnt_ = request.getParameter("cnt");

        if (cnt_ != null && !cnt_.equals(""))
            cnt = Integer.parseInt(cnt_);


        for(int i=0; i<cnt; i++) {
            out.println((i+1)+": 안녕 Servlet!!<br />");
        }

    }
}
