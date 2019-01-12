package day6;

/**
 *
 * 1：抛异常 throws ： 将异常抛出去 ，让调用者去解决异常
 *
 *
 * 2: catch  平级没有顺序   。如果有继承关系 ，应该先抓子类 ，再抓父类
 *
 *
 * 3：finally 无论读写是否成功一定执行
 *
 *
 * 4：RuntimeException   ： 运行异常不需要 throws 也不需要catch  ，需要你修改源代码
 * 其他异常处理了，可以执行，这样的异常出现了，就不要处理，直接改代码
 *
 *
 * 5： 子类重写父类时，异常的处理
 *          1：如果父类抛出异常 ，子类可抛可不抛 ，但是等级不能大于父类
 *          2：父类不抛出异常 ，子类就不能抛出异常
 *          3：如果子类调用抛出异常的方法 ， 只能用 try... catch
 *
 *
 * Created by Administrator on 2019\1\12 0012.
 */
public class throw_test {

    public void test(int[] arr) throws Exception{  //在方法上标明有异常

        if(arr == null){
            throw new NullPointerException("数组为null");    // 不加s ，需要跟对象
        }

        if(arr.length <3){
            throw new IndexOutOfBoundsException("超过边界");
//            throw new RuntimeException()
        }

    }
}
