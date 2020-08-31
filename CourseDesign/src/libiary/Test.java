package libiary;

import java.util.Date;

/**
 * @author Ji Rui
 * @date 2020/8/31 10:21
 */
public class Test {

    public static void main(String[] args) {

        ManagementSystem managementSystem = new ManagementSystem();

        init(managementSystem);

        Book book;

        System.out.println(managementSystem.skipList.get(10001).value.toString());

        boolean f = managementSystem.addBook(new Book(10001));

        if(f == Boolean.TRUE) {
            System.out.println("采购成功！");
        } else {
            System.out.println("增加库存");
        }

        System.out.println("-----采购入库-----");

        System.out.println(managementSystem.skipList.get(10001).value.toString());

        int flag = managementSystem.lendBook(10001, "1806010633", new Date());
        System.out.println("应还时间："+(new Date()).toString());

        if(1 == flag) {
            System.out.println("借出成功！");
        } else if(0 == flag) {
            System.out.println("库存不足");
        } else if(-1 == flag) {
            System.out.println("未收录");
        }

        System.out.println("-----借出-----");

        System.out.println(managementSystem.skipList.get(10001).value.toString());

        flag = managementSystem.returnBook(10001, "1806010633", new Date());
        System.out.println("归还时间："+(new Date()).toString());

        if(1 == flag) {
            System.out.println("成功归还！");
        } else if(0 == flag) {
            System.out.println("超期归还");
        } else if(-1 == flag) {
            System.out.println("不是本馆藏书");
        }

        System.out.println(managementSystem.skipList.get(10001).value.toString());
    }

    public static void init(ManagementSystem managementSystem) {

        Book book1 = new Book();
        book1.setId(10001);
        book1.setName("数据结构");
        book1.setAuthor("张乃孝");
        book1.setExistingStock(5);
        book1.setTotalStock(5);
        managementSystem.addBook(book1);

        Book book2 = new Book();
        book2.setId(10002);
        book2.setName("计算机组成与系统结构");
        book2.setAuthor("白中英");
        book2.setExistingStock(8);
        book2.setTotalStock(10);
        managementSystem.addBook(book2);

        Book book3 = new Book();
        book3.setId(10004);
        book3.setName("马克思主义基本原理概论");
        book3.setAuthor("马克思主义基本原理概论编写组");
        book3.setExistingStock(8);
        book3.setTotalStock(8);
        managementSystem.addBook(book3);
    }
}
