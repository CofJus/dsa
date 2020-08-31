package libiary;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Ji Rui
 * @date 2020/8/31 9:02
 */
public class ManagementSystem {

    SkipList<Book> skipList;

    public ManagementSystem() {
        skipList = new SkipList<>();
    }

    /**
     * 图书入库
     * 如果表中已有，则只将库存量增加
     * @param book 要入库的图书
     * @return a)新增种类(true) b)增加馆藏(false)
     */
    public boolean addBook(Book book) {
        int id = book.getId();
        if(null == skipList.get(book.getId())) {
            skipList.put(id, book);
            return true;
        }
        else {
            int curStock = skipList.get(id).value.getExistingStock();
            skipList.get(id).value.setExistingStock(curStock + 1);
            skipList.get(id).value.setTotalStock(skipList.get(id).value.getTotalStock() + 1);
            return false;
        }
    }

    /**
     * 借出
     * @param bookId 要借出的图书id
     * @param readerId 读者借阅证号
     * @param date 借书日期
     * @return a)馆藏中没有本书(-1) b)馆藏数不足(0) c)成功借出(1)
     */
    public int lendBook(int bookId, String readerId, Date date) {
        if(null == skipList.get(bookId)) {
            return -1;
        }
        Book book = skipList.get(bookId).value;
        if(0 > book.getExistingStock()) {
            return 0;
        }
        HashMap<String, Date> hashMap = book.getInformation();
        hashMap.put(readerId, date);
        book.setInformation(hashMap);
        book.setExistingStock(book.getTotalStock() - 1);
        skipList.get(bookId).setValue(book);
        return 1;
    }

    /**
     * 还书
     * @param bookId 图书id
     * @param readerId 读者借阅证id
     * @param curDate 还书时间
     * @return a)馆藏中没有本书(-1) b)超期归还(0) c)按时归还(1)
     */
    public int returnBook(int bookId, String readerId, Date curDate) {
        if(null == skipList.get(bookId)) {
            return -1;
        }
        Book book = skipList.get(bookId).value;
        book.setExistingStock(book.getExistingStock() + 1);
        HashMap<String, Date> hashMap = book.getInformation();
        Date date = hashMap.get(readerId);
        hashMap.remove(readerId);
        book.setInformation(hashMap);
        skipList.get(bookId).setValue(book);
        if(date.before(curDate)) {
            return 0;
        }
        return 1;
    }
}
