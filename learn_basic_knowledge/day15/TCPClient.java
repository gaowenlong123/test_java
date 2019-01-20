package day15;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * 1：区别 ： 严格区分客户端和服务器  ，服务器要提前启动 ，客户端向服务端发送请求实现同路连接中建立一个IO对象，
 *
 *          执行服务器的 serversocket
 *          客户端   socket
 *
 *
 * 2：流向问题
 *
 *
 * Created by Administrator on 2019\1\20 0020.
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {

        //创建socket对象 ，连接服务器
        Socket socket = new Socket("127.0.0.1" , 8888);


        //玩的是流
        //通过客户端的套接字对象Socket方法，获取字节输出流，将数据写入服务器
        OutputStream out = socket.getOutputStream();
        out.write("服务器OK".getBytes());

        //读取服务器端的返回值
        InputStream in = socket.getInputStream();
        byte[] data = new byte[1024];
        int len = in.read(data);

        System.out.println(new String(data , 0 ,len));

        socket.close();


    }
}
