package com.gao.web.servlet;


import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/4 0004.
 */
@WebServlet("/test_HttpServlet4")
public class test_HttpServlet4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //生成验证码
        ValidateCode vc  = new ValidateCode(100 ,20 ,4,6);
        vc.write(resp.getOutputStream());


    }
}
