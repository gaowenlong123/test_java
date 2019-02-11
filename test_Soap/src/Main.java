import com.gao.weather.WeatherInterfaceImpl;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");

        //1.写服务接口

        //2.添加webservice注解

        //3.发布服务
        Endpoint.publish("http://127.0.0.1:80/weather",new WeatherInterfaceImpl());

        //4.访问服务
        //http://127.0.0.1/weather?wsdl 说明书
    }
}
