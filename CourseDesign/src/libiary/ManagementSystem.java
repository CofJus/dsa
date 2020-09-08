package libiary;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Ji Rui
 * @date 2020/8/31 9:02
 */
public class ManagementSystem {

    SkipList<Book> bookSkipList;

    SkipList<Student> studentSkipList;

    public ManagementSystem() {
        this.bookSkipList = new SkipList<>();
        this.studentSkipList = new SkipList<>();
    }

    /**
     * 图书入库
     * 如果表中已有，则只将库存量增加
     * @param book 要入库的图书
     * @return a)新增种类(true) b)增加馆藏(false)
     */
    public boolean addBook(Book book) {
        int id = book.getId();
        if(null == bookSkipList.get(book.getId())) {
            bookSkipList.put(id, book);
            return true;
        }
        else {
            int curStock = bookSkipList.get(id).value.getExistingStock();
            bookSkipList.get(id).value.setExistingStock(curStock + book.getExistingStock());
            bookSkipList.get(id).value.setTotalStock(bookSkipList.get(id).value.getTotalStock() + book.getTotalStock());
            return false;
        }
    }

    /**
     * 借出
     * @param bookId 要借出的图书id
     * @param readerId 读者借阅证号
     * @param date 借书日期
     * @return a)馆藏中没有本书(-1) b)馆藏数不足(0) c)成功借出(1) d)无该学生信息(-2)
     */
    public int lendBook(int bookId, int readerId, Date date) {
        if(null == bookSkipList.get(bookId)) {
            return -1;
        }

        if(null == studentSkipList.get(readerId)) {
            return -2;
        }

        Book book = bookSkipList.get(bookId).value;
        if(0 > book.getExistingStock()) {
            return 0;
        }
        //设置为5分钟后归还
        book.getInformation().put(readerId, new Date(date.getTime() + 300000));
        book.setExistingStock(book.getTotalStock() - 1);
        bookSkipList.get(bookId).setValue(book);

        studentSkipList.get(readerId).getValue().getInformation().put(bookId, new Date(date.getTime() + 300000));
        //System.out.println("hash------"+studentSkipList.get(readerId).getValue().getInformation());
        return 1;
    }

    /**
     * 还书
     * @param bookId 图书id
     * @param readerId 读者借阅证id
     * @param curDate 还书时间
     * @return a)馆藏中没有本书(-1) b)超期归还(0) c)按时归还(1)
     */
    public int returnBook(int bookId, int readerId, Date curDate) {
        if(null == bookSkipList.get(bookId)) {
            return -1;
        }
        Book book = bookSkipList.get(bookId).value;
        book.setExistingStock(book.getExistingStock() + 1);
        HashMap<Integer, Date> hashMap = book.getInformation();
        Date date = hashMap.get(readerId);
        hashMap.remove(readerId);
        book.setInformation(hashMap);
        bookSkipList.get(bookId).setValue(book);
        studentSkipList.get(readerId).getValue().getInformation().remove(bookId);
        if(date.before(curDate)) {
            return 0;
        }
        return 1;
    }

    /**
     * 录入学生信息
     * @param student the student
     * @return 是否已经存在学生信息,是(false),否(true)
     */
    public boolean addStudent(Student student) {
        int id = student.getId();
        if(null != studentSkipList.get(id)) {
            return false;
        }
        else {
            studentSkipList.put(id, student);
            return true;
        }
    }

    /**
     * 查找学生信息
     * @param id the id
     * @return the student
     */
    public Student findStudent(int id) {
        return studentSkipList.get(id).getValue();
    }

    /**
     * 查找图书信息
     * @param id the id
     * @return the book
     */
    public Book findBook(int id) {
        return bookSkipList.get(id).value;
    }
}
