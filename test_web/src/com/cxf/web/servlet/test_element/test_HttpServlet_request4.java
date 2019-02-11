package com.cxf.web.servlet.test_element;

import com.cxf.model.account;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * 通过导入包 自动将传入的request值 与设定的javaBean进行匹配赋值
 *
 * Created by Administrator on 2019/2/4 0004.
 */
@WebServlet("/test_HttpServlet_request4")
public class test_HttpServlet_request4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //post请求时，中文会乱码,解决方法setCharacterEncoding,只针对post请求有效
        request.setCharacterEncoding("UTF-8");
        account account = new account();
        try {

            BeanUtils.populate(account, request.getParameterMap());

        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(account);
        //account [username=gf, password=gfg, gender=null, hobby=[赚钱, 游戏], remark=gfg]
    }

}