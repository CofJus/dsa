package libiary;

import java.util.Date;
import java.util.Scanner;

/**
 * @author Ji Rui
 * @date 2020/8/31 10:21
 */
public class Test {

    public static void main(String[] args) {

        ManagementSystem managementSystem = new ManagementSystem();

        initBook(managementSystem);
        initStudent(managementSystem);
        initView();

        Scanner scanner = new Scanner(System.in);
        int instruction = 0;

        while (true) {
            instruction = scanner.nextInt();
            if (0 == instruction) {
                break;
            } else if (1 == instruction) {
                System.out.println("-----查找-----");
                System.out.println("-----输入要查找的书号-----");
                int bookId = scanner.nextInt();
                Book book = managementSystem.findBook(bookId);
                System.out.println(book.toString());
            } else if (2 == instruction) {
                System.out.println("-----采购入库-----");
                System.out.println("-----输入要入库的书号-----");
                int bookId = scanner.nextInt();
                System.out.println("-----输入采购量-----");
                int count = scanner.nextInt();
                boolean flag = managementSystem.addBook(getNewBook(bookId, "", "", count, count));
                if (flag == Boolean.TRUE) {
                    System.out.println("-----采购成功！-----");
                } else {
                    System.out.println("-----增加库存-----");
                }
                System.out.println("-----采购后图书信息-----");
                System.out.println(managementSystem.bookSkipList.get(bookId).value.toString());
            } else if (3 == instruction) {
                System.out.println("-----借书-----");
                System.out.println("-----输入借阅证号-----");
                int readerId = scanner.nextInt();
                System.out.println("-----输入书号-----");
                int bookId = scanner.nextInt();
                int flag = managementSystem.lendBook(bookId, readerId, new Date());
                if (-1 == flag) {
                    System.out.println("-----图书馆中没有本书-----");
                } else if (0 == flag) {
                    System.out.println("-----库存不足-----");
                } else if (-2 == flag) {
                    System.out.println("-----学生信息不存在-----");
                } else if (1 == flag) {
                    System.out.println("-----借出成功-----");
                }
                System.out.println("-----借书后图书信息-----");
                System.out.println(managementSystem.bookSkipList.get(bookId).value.toString());
                System.out.println("-----借书后读者信息-----");
                System.out.println(managementSystem.studentSkipList.get(readerId).value.toString());
            } else if (4 == instruction) {
                System.out.println("-----还书-----");
                System.out.println("-----输入借阅证号-----");
                int readerId = scanner.nextInt();
                System.out.println("-----输入书号-----");
                int bookId = scanner.nextInt();
                int flag = managementSystem.returnBook(bookId, readerId, new Date());
                if (1 == flag) {
                    System.out.println("成功归还！");
                } else if (0 == flag) {
                    System.out.println("超期归还");
                } else if (-1 == flag) {
                    System.out.println("不是本馆藏书");
                }
                System.out.println("-----还书后图书信息-----");
                System.out.println(managementSystem.bookSkipList.get(bookId).value.toString());
                System.out.println("-----还书后读者信息-----");
                System.out.println(managementSystem.studentSkipList.get(readerId).value.toString());
            } else if (5 == instruction) {
                System.out.println("-----学生信息-----");
                System.out.println("-----输入借阅证号-----");
                int readerId = scanner.nextInt();
                System.out.println(managementSystem.findStudent(readerId).toString());
            } else if (9 == instruction) {
                System.out.println("-----退出-----");
                break;
            }
        }
    }

    public static Book getNewBook(int id, String name, String author, int existingStock, int totalStock) {
        Book book = new Book(id);
        book.setName(name);
        book.setAuthor(author);
        book.setExistingStock(existingStock);
        book.setTotalStock(totalStock);
        return book;
    }

    public static Student getNewStudent(int id, String name) {
        return new Student(id, name);
    }

    public static void initBook(ManagementSystem managementSystem) {
        managementSystem.addBook(getNewBook(10001, "数据结构", "张乃孝", 5, 5));
        managementSystem.addBook(getNewBook(10002, "计算机组成与系统结构", "白中英", 8, 10));
        managementSystem.addBook(getNewBook(10004, "马克思主义基本原理概论", "马克思主义基本原理概论编写组", 8, 8));
    }

    public static void initStudent(ManagementSystem managementSystem) {
        managementSystem.addStudent(getNewStudent(1806010633, "季锐"));
    }

    public static void initView() {
        System.out.println("1:查找图书信息");
        System.out.println("2:采购入库");
        System.out.println("3:借书");
        System.out.println("4:还书");
        System.out.println("5:查找读者信息");
    }
}
