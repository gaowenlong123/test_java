package day15;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * 1: 线程阻塞效果
 *
 * Created by Administrator on 2019\1\20 0020.
 */
public class UDPReceive {

    public static void main(String[] args) throws IOException {

        //端口号只用占用一次
        DatagramSocket ds = new DatagramSocket(6000);

        byte[] data = new byte[1024];



        while (true) {

            DatagramPacket dp = new DatagramPacket(data,data.length);

            ds.receive(dp);

            //得到发送端的IP
            String ip = dp.getAddress().getHostAddress();

            //发送端口
            int port = dp.getPort();

            //拆包
            int length = dp.getLength();
            System.out.println(new String(data, 0, length) + ip + port);

        }

//        ds.close();

    }
}
