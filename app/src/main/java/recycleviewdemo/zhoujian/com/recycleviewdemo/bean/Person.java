package recycleviewdemo.zhoujian.com.recycleviewdemo.bean;

/**
 * Created by zhoujian on 2016/12/30.
 */

public class Person
{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +"name='" + name + '\'' +'}';
    }
}
