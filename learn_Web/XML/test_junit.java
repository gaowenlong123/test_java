package XML;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.List;

/**
 * Created by Administrator on 2019\2\3 0003.
 */
public class test_junit {

    @Test
    public void test1() throws Exception{
        //SAX解析 ，使用dcom4j
        //创建reader对象
        SAXReader reader = new SAXReader();

        //读取文档
        Document doc = reader.read(new FileInputStream("D:\\java_test\\test_java\\learn_Web\\XML\\test.xml"));

        //获取根标签
        Element root = doc.getRootElement();
        System.out.println(root.getName());

        //获取子标签
        List<Object> book = root.elements();

        for(Object a : book){
            System.out.println(a.getClass());
            Element book1 = (Element)a;
            System.out.println(book1.getName());
        }

    }

    @Test
    public void test2(){
        //根据xpath来查询
        /*  // nodename 选择该节点
         *  /  从根节点中选择 ，
         *  .. 选择当前节点的父节点
         *  @  选择属性             */
    }


}
