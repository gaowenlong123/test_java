package day11;

/**
 * Created by Administrator on 2019\1\15 0015.
 */
public class ouput implements Runnable{

//    private Resource r =new Resource();

    private Resource r ;

    public ouput(Resource r){
        this.r=r;
    }

    public void run(){
        while (true){

            synchronized (r) {
                if(!r.flag){
                    try {
                        r.wait();
                    }catch (Exception e){

                    }
                }
                System.out.println(r.name + "----" + r.sex);

                r.flag =false;
                r.notify();
            }
        }

    }
}
