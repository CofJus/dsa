package list.student;

/**
 * @author Ji Rui
 * @date 2020/8/23 20:15
 */
public class Student {

    private String name;
    private String id;
    private int grade;

    Student next = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
