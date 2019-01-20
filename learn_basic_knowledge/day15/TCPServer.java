package day15;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * Created by Administrator on 2019\1\20 0020.
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);
        //调用服务器套接字对象中的方法accept（） 获取客户端套接字对象
        Socket socket = server.accept();


        //玩的是流
        InputStream in = socket.getInputStream();
        byte[] data = new byte[1024];
        int len = in.read(data);

        System.out.println(new String(data , 0 ,len));


        //服务器端向客户端回数据，字节的输出流,通过客户端客户端套接字对象，获取字节输出流
        OutputStream out = socket.getOutputStream();
        out.write("收到，谢谢".getBytes());





        socket.close();
        server.close();


    }
}
