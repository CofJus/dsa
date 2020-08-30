package list.student;

import java.util.LinkedList;

/**
 * @author Ji Rui
 * @date 2020/8/23 20:13
 */
public class ManagementSystem implements List{

    Student head;

    private int curSize;

    private Student cur;

    public ManagementSystem() {
        this.curSize = 0;
        this.head = new Student();
        this.cur = head;
    }

    @Override
    public int insert(Student student) {
        curSize++;
        cur.next = student;
        cur = cur.next;
        return curSize;
    }

    @Override
    public boolean delete(String id) {
        Student s = head;
        while(s != null) {
            if(s.getId() != null && s.getId().equals(id)) {
                this.getPre(id).next = s.next;
                return true;
            }
            s = s.next;
        }
        return false;
    }

    @Override
    public Student getPre(String id) {
        Student s = head;
        while(s != null) {
            if(s.next.getId().equals(id)) {
                return s;
            }
            s = s.next;
        }
        return null;
    }

    @Override
    public int getStatistics(int low, int high) {
        int res = 0;
        Student s = head;
        while(s != null) {
            if(s.getGrade() <= high && s.getGrade() >= low) {
                res++;
            }
            s = s.next;
        }
        return res;
    }

    @Override
    public LinkedList<Student> traverse() {

        LinkedList<Student> res = new LinkedList<>();
        Student s = this.head;
        while (s != null) {
            res.add(s);
            s = s.next;
        }
        return res;
    }
}
