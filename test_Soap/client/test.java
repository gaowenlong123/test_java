import generate.WeatherInterfaceImpl;
import generate.WeatherInterfaceImplService;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Administrator on 2019/2/11 0011.
 */
public class test {

    // 使用 wsimport 导入文件

    @Test
    public void test1() {
        System.out.println("Hello World!");
//        创建服务窗口
        WeatherInterfaceImplService service = new WeatherInterfaceImplService();

//        通过服务对象找到服务端点
        WeatherInterfaceImpl port = service.getPort(WeatherInterfaceImpl.class);

//        调用webservice的方法
        String weatherInfo = port.queryWeather("深圳");

        System.out.println(weatherInfo);
    }

    @Test
    public void test2() throws Exception {

        //发送webservice的网络基于soap网络请求
        /**
         * HttpURLConnection  自己在代码中请求url 。 不使用生成的soap
         */


        //1.创建URL【访问路径】
        URL url = new URL("http://127.0.0.1:12345/weather");

        //2.创建连接
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        //3.设置请求头
        httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("content-type","text/xml; charset=utf-8");

        //4.设置请求参数
        httpConn.setDoOutput(true);//可以写数据
        OutputStream os =  httpConn.getOutputStream();
        os.write(paramtersStr("广州").getBytes());

        //5.接收服务器响应数据
        InputStream is = httpConn.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = is.read(buf)) != -1){
            //把字节转成字符串
            System.out.println(new String(buf,0,len,"utf-8"));
        }

        //6.关流
        is.close();
        os.close();


    }

    public static String paramtersStr(String cityName){
        return  "<?xml version=\"1.0\" ?>\n" +
                "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "\t<S:Body>\n" +
                "\t\t<ns2:queryWeather xmlns:ns2=\"http://weather.gyf.com/\">\n" +
                "\t\t\t<arg0>"+ cityName+"</arg0>\n" +
                "\t\t</ns2:queryWeather>\n" +
                "\t</S:Body>\n" +
                "</S:Envelope>";
    }
}
