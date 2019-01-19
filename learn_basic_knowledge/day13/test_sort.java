package day13;

/**
 *
 * 1：
 *
 *
 * Created by Administrator on 2019\1\19 0019.
 */
public class test_sort {

    //成员变量要和数据库对上

    private int sid;
    private String sname;
    private double Sprice;
    private String sdesc;

    public test_sort(int sid, String sname, double sprice, String sdesc) {
        this.sid = sid;
        this.sname = sname;
        Sprice = sprice;
        this.sdesc = sdesc;
    }

    public test_sort() {}

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public double getSprice() {
        return Sprice;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSprice(double sprice) {
        Sprice = sprice;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    @Override
    public String toString() {
        return "test_sort{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", Sprice=" + Sprice +
                ", sdesc='" + sdesc + '\'' +
                '}';
    }
}
