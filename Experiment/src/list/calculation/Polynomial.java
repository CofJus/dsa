package list.calculation;

/**
 * @author Ji Rui
 * @date 2020/8/23 21:45
 */
public class Polynomial {

    Item head;

    Item cur;

    int curSize;

    public Polynomial() {
        //头节点无意义
        this.head = new Item(0, 0);
        this.cur = this.head;
        curSize = 0;
    }

    public void insert(Item item) {
        curSize++;
        cur.next = item;
        cur = cur.next;
    }

    /**
     * 两式相加
     * @param polynomial 第二个式子
     * @return 返回结果（在原有的式子上修改）
     */
    public Polynomial add(Polynomial polynomial) {
        Polynomial max = this.curSize > polynomial.curSize ? this : polynomial;
        Polynomial min = this.curSize < polynomial.curSize ? this : polynomial;

        Item t1 = max.head;
        Item t2 = min.head;

        Item p = t1;

        while(null != t2) {
            while(null != p) {
                if(p.index == t2.index) {
                    p.coefficient += t2.coefficient;
                    break;
                }
                p = p.next;
            }
            t2 = t2.next;
        }
        return max;
    }

    /**
     * 打印多项式
     */
    public void print() {
        Item item = this.head;
        while(null != item) {
            System.out.println("index:"+item.index+"  coefficient:"+item.coefficient);
            item = item.next;
        }
    }
}
