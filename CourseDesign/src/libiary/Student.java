package libiary;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Ji Rui
 * @date 2020/9/8 16:37
 */
public class Student {

    private int id;
    private String name;

    /** <书id, 应还日期> */
    private HashMap<Integer, Date> information;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.information = new HashMap<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Date> getInformation() {
        return information;
    }

    public void setInformation(HashMap<Integer, Date> information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", information=" + information +
                '}';
    }
}
