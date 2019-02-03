package day2;

/**
 *
 * 1：equals    比较两个对象的内存地址
 *
 * 重写父类方法
 *
 *2：toString  当输出一个对象，就默认调用   对象.tostring()
 *
 *
 *
 * Created by Administrator on 2018/12/31 0031.
 */
public class object_test extends Object{

    int age=10;
    String name = "";
    public boolean equals(Object obj ){
        if(this == obj){
            return true;
        }
        if(obj ==null){
            return false;
        }
        if(obj instanceof object_test){
            object_test a = (object_test)obj;
            return this.age == a.age;
        }
        return false;
    }

    //15_05
    public String toString(){
        return this.name;
    }

    public static void main(String[] args) {
        byte[] bytes = {97,98,99};
        String s1 = new String(bytes);

        String s = "gogogog";
        s.substring(1,5);  //前包含后不包含
        s.startsWith("go");  // 是否以go前缀开始
        s.endsWith("go");
        s.contains("go");
        int index = s.indexOf("o");
        s.toCharArray();
        s.equalsIgnoreCase("Assss");  //判断字符串是否形同，忽略大小写
    }

}
