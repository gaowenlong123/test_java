package day16;

/**
 * 1：
 *
 * Created by Administrator on 2019\1\20 0020.
 */
public class person {

    private int age ;
    public String name;

    private person(int age) {
        this.age = age;
    }

    public person(String name) {
        this.name = name;
    }

    public person() {}

    public person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString(){

        return "name"+this.name + "age"+this.age ;
    }

    public void eat(){
        System.out.println("aaaa");
    }

    public void sleep(int time){
        System.out.println("sleep" +time);
    }

}
