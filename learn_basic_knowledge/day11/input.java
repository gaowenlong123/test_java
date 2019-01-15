package day11;


import day11.Resource;

/**
 *
 * 1： 资源类 ，控制线程 ，使线程唤醒和等待
 *
 *
 * Created by Administrator on 2019\1\15 0015.
 */
public class input implements Runnable
{
//    private Resource r =new Resource();

    private Resource r ;

    public input(Resource r){
        this.r=r;
    }

    public void run(){
        int i = 0;
        while (true){
            synchronized (r) {            //这里不加this ，加r ，因为r是唯一的

                if (r.flag){
                    try {
                        r.wait();
                    }catch (Exception e){

                    }
                }

                if (i % 2 == 1) {
                    r.name = "a";
                    r.sex = "nv";
                } else {

                    r.name = "b";
                    r.sex = "nan";
                }

                r.flag = true;
                r.notify();          //当前，就是自己的线程一定是运行的，所以就是唤醒input中睡眠的线程
            }

            i++;
        }


    }

}
