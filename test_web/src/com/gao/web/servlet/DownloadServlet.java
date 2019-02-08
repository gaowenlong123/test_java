package com.gyf.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 文件下载的秘诀
 * 1.设置两个响应头
 * 2.如果文件是中文名，要进行URLEncode
 * 3.通过输入流读数据，通过输出流response.getOutputStream 输出数据给客户端面
 *
 * 练习：
 * localhost:8080/DownloadServlet?fileName=xxxxx.jpg 通过传参数来下载文件
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //实现文件的下载
        //1.指定文下载的路径
        //String fileName = "badab692-529b-4eb7-9f18-65ba44ea5475.jpg";
        String fileName = "工作室.jpg";
        String path = "C:\\Users\\10301\\Desktop\\test\\" + fileName;

        //2.设置响应头
        //2.1 Content-Disposition
        //如果是中文文件，要设置URL编码
        fileName = URLEncoder.encode(fileName,"UTF-8");
        response.setHeader("Content-Disposition","attachment;filename=" + fileName);

        //2.2Content-Type
        //response.setHeader("content-type");
        response.setContentType("application/octet-stream");//以二进制的数据返回给客户端

        //3.把数据返回给客户端
        //通过输入流读数据
        FileInputStream fis = new FileInputStream(new File(path));

        //通过输出流写数据 Alt + enter 导包
        ServletOutputStream sos =response.getOutputStream();

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1){
            sos.write(buf,0,len);
        }

        //关闭流
        fis.close();
        sos.close();//如果你不关,tomcat会关
    }
}
