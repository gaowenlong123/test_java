package com.gyf.web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //解析表单数据
        //1.创建工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();

        //2.获取文件上传对象
        ServletFileUpload sfu = new ServletFileUpload(factory);

        //设置单个文件上传的大小
        sfu.setFileSizeMax(1024 * 1024 * 2);//2M
        //3.获取FileItem
        try{
            //FileItem相当一个Input标签的数据
            List<FileItem> items = sfu.parseRequest(request);
            for(FileItem item: items){
                if(item.isFormField()){//普通数据
                    System.out.println(item.getFieldName() + "---" + item.getString("UTF-8"));
                }else{//文件数据
                    System.out.println("文件名:" + item.getName());
                    System.out.println("文件类型:" + item.getContentType());
                    System.out.println("文件大小:" + item.getSize());
                    //System.out.println("文件内容.." + item.getString());
                    //如果是文件，需要把文件保存到本地
                    //1.指定文件保存的目录
                    // 添加一个日期目录
                   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                   String dateStr = sdf.format(new Date());
                   /*String  path = request.getServletContext().getRealPath("upload/" + dateStr);*/

                   //把日期转成16进制的字节串
                    String dateHexStr = Integer.toHexString(dateStr.hashCode());
                   String  path = request.getServletContext().getRealPath("upload/" + dateHexStr);
                    System.out.println("保存文件的路径：" + path);

                    //2.创建文件夹
                    File dir = new File(path);
                    if(!dir.exists()){
                        dir.mkdirs();
                        System.out.println("创建文件夹了");

                    }else{
                        System.out.println("文件夹已经存在");
                    }

                    //3.把上传的文件保存
                    //3.1 指定文件保存的名字
                    //后缀名
                    String suffix = item.getName().split("\\.")[1];
                    //文件名
                    String fileName = UUID.randomUUID().toString() + "." + suffix;


                    //3.2 拼接文件保存路径
                    String fileSavePath = path + "\\" + fileName;
                    System.out.println("保存文件完整路径:" + fileSavePath);

                    //3.3 保存
                    item.write(new File(fileSavePath));
                    item.delete();//删除临时文件
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取表单提交原始数据
        InputStream is = request.getInputStream();

        //2.读取数据
        byte[] buf = new byte[1024];
        int len = 0;
        while (( len = is.read(buf)) != -1){
            //把字节转成utf-8的编码字符串
            String str = new String(buf,0,len,"UTF-8");
            System.out.println(str);
        }
    }


}
