package com.gao.servlet;



import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2019/2/4 0004.
 */
//取名
@WebServlet("/test_HttpServlet3")
public class test_HttpServlet3 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //下载 ： 把文件的数据（二进制）响应客户端

        //1:文件名
        String filename = "tips.txt";
        String path = "D:\\JavaProjects\\test_java\\test_web\\src\\com\\gao\\servlet\\tips.txt";

        //必须设置相应类型
        //如果有中文 ， 需要对文本进行 urlencode ,把中文变成%号的形式
        filename = URLEncoder.encode(filename,"UTF-8");
        resp.setHeader("Content-disposition" , "attachment;filename"+filename);

        //2获取文件输入流
        FileInputStream fis = new FileInputStream(path);

        //3获取输出流
        ServletOutputStream sos = resp.getOutputStream();

        //4:从文件中读取数据 ，  响应客户端
        byte[] buf = new byte[1024];
        int len =0;
        while ((len = fis.read(buf)) != -1){
            sos.write(buf  , 0 ,len);
        }

        //输入流关闭 ， 输出流会自动关闭
        fis.close();

    }
}

