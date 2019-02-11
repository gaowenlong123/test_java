import com.rest.api.service.StudentServiceImpl;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

// rest 在以后会经常用到

//http://127.0.0.1:12345/user/student/query/1

//这些url 都是给移动客户端访问的    在 Tools/ Test RestFul Web Service 测试自己的代码

public class Main_test {
    public static void main(String[] args) {
        /**
         *JaxWsServerFactoryBean:发布soap
         * JAXRSServerFactoryBean：发布rest
         */
        JAXRSServerFactoryBean service = new JAXRSServerFactoryBean();

        //设置服务接口
        service.setResourceClasses(StudentServiceImpl.class);
        //设置服务实现
        service.setServiceBean(new StudentServiceImpl());

        //设置地址
        service.setAddress("http://127.0.0.1:12345/user");

        //发布服务
        service.create();
    }
}
