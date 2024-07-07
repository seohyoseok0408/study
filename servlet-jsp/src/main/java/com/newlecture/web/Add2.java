package com.newlecture.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add2")
public class Add2 extends HttpServlet { // 입력 데이터 배열로 받기
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        String[] num_ = req.getParameterValues("num");

        int result = 0;

        for(int i=0; i<num_.length; i++) {
            int num = Integer.parseInt(num_[i]);
            result += num;
        }


        out.println("계산 결과는 : " + result);

    }
}
