package libiary;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Ji Rui
 * @date 2020/8/30 15:42
 */
public class Book {

    /** 作为SkipList中的key */
    private int id;

    private String name;
    private String author;

    private int existingStock;
    private int totalStock;

    /** <借阅证号, 应还日期> */
    private HashMap<String, Date> information;

    public Book() {
        this.id = -1;
        this.name = "";
        this.author = "";
        this.existingStock = 0;
        this.totalStock = 0;
        information = new HashMap<>();
    }

    public Book(int id) {
        this.id = id;
        this.name = "";
        this.author = "";
        this.existingStock = 0;
        this.totalStock = 0;
        information = new HashMap<>();
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getExistingStock() {
        return existingStock;
    }

    public void setExistingStock(int existingStock) {
        this.existingStock = existingStock;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public HashMap<String, Date> getInformation() {
        return information;
    }

    public void setInformation(HashMap<String, Date> information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", existingStock=" + existingStock +
                ", totalStock=" + totalStock +
                ", information=" + information +
                '}';
    }
}
