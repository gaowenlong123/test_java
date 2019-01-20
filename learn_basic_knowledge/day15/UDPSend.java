package day15;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.UnknownHostException;
import java.util.Scanner;

/**
 *
 *
 * 1：实现udp发送端
 *          包装类
 *          发送端
 *
 * 2:接受端
 *          1：没有接受端，数据就会丢失
 *
 * Created by Administrator on 2019\1\20 0020.
 */
public class UDPSend {

    public static void main(String[] args) throws IOException {


        //键盘输入
        Scanner sc = new Scanner(System.in);
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramSocket ds = new DatagramSocket();

        while (true) {

            String message = sc.nextLine();
            byte[] data = message.getBytes();
            DatagramPacket dp = new DatagramPacket(data, data.length, inet, 6000);

            ds.send(dp);
        }

//        ds.close();

    }

    public void send() throws IOException {
        //打包数据 ， 封装要发送的数据，接受端IP，端口
        byte[] data = "你好UDP".getBytes();

        //创建对象，封装Ip对象
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp =new DatagramPacket(data,data.length ,inet,6000);


        //数据包的发送和接受
        DatagramSocket ds = new DatagramSocket();
        ds.send(dp);
        ds.close();
    }


}
