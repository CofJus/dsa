package list.student;

import java.util.LinkedList;

/**
 * @author Ji Rui
 * @date 2020/8/23 21:00
 */
public class Test {
    public static void main(String[] args) {

        ManagementSystem managementSystem = new ManagementSystem();

        //插入
        for (int i = 0; i < 10; ++i) {
            Student student = new Student();
            student.setName("----");
            student.setId(String.valueOf(i));
            student.setGrade(i);
            managementSystem.insert(student);
        }
        print(managementSystem);

        //删除3
        managementSystem.delete("3");
        print(managementSystem);

        //统计结果
        System.out.println("人数:" + managementSystem.getStatistics(3, 8));
    }

    /** 打印遍历结果集 */
    public static void print(ManagementSystem managementSystem) {
        LinkedList<Student> res = managementSystem.traverse();
        for (Student student : res) {
            System.out.println("id:" + student.getId() + "      grade:" + student.getGrade());
        }
        System.out.println("----END----");
    }
}