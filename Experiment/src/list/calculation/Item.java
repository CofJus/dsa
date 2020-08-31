package list.calculation;

/**
 * @author Ji Rui
 * @date 2020/8/23 21:41
 */
public class Item {
    /** 指数 */
    int index;

    /** 系数 */
    int coefficient;

    Item next;

    public Item(int index, int coefficient) {
        this.index = index;
        this.coefficient = coefficient;
        this.next = null;
    }
}
