package libiary;

import java.util.Random;

/**
 * @author Ji Rui
 * @date 2020/8/30 19:08
 */

public class SkipList<T> {

    private SkipListNode<T> head, tail;

    private int size;
    private int listLevel;

    private final Random random;
    private static final double PROBABILITY = 0.5;

    public SkipList() {
        head = new SkipListNode<T>(SkipListNode.HEAD_KEY, null);
        tail = new SkipListNode<>(SkipListNode.TAIL_KEY, null);
        head.next = tail;
        tail.pre = head;
        size = 0;
        listLevel = 0;
        random = new Random();
    }

    /**
     * 根据key查找
     * @param key key
     * @return SkipListNode<T>
     */
    public SkipListNode<T> get(int key) {
        SkipListNode<T> p = findNode(key);
        if (p.key == key) {
            return p;
        }
        return null;
    }

    /**
     * 首先查找到包含key值的节点，将节点从链表中移除，接着如果有更高level的节点，则repeat这个操作即可。
     * @param key key
     * @return T(删除的数据)
     */
    public T remove(int key) {
        SkipListNode<T> p = get(key);
        if (p == null) {
            return null;
        }
        T oldV = p.value;
        SkipListNode<T> q;
        while (p != null) {
            q = p.next;
            q.pre = p.pre;
            p.pre.next = q;
            p = p.up;
        }
        return oldV;
    }

    /**
     * 插入
     * put方法有一些需要注意的步骤：
     * 1.如果put的key值在跳跃表中存在，则进行修改操作；
     * 2.如果put的key值在跳跃表中不存在，则需要进行新增节点的操作，并且需要由random随机数决定新加入的节点的高度（最大level）；
     * 3.当新添加的节点高度达到跳跃表的最大level，需要添加一个空白层（除了-oo和+oo没有别的节点）
     * @param key key
     * @param value value
     */
    public void put(int key, T value) {
        SkipListNode<T> p = findNode(key);
        //如果已经存在，则终止插入操作
        if (p.key == key) {
            p.value = value;
            return;
        }

        SkipListNode<T> q = new SkipListNode<>(key, value);
        insertNode(p, q);

        //随机决定是否升层
        int currentLevel = 0;
        while (random.nextDouble() > PROBABILITY) {
            if (currentLevel >= listLevel) {
                addEmptyLevel();
            }
            while (p.up == null) {
                System.out.println(p);
                p = p.pre;
            }
            p = p.up;
            SkipListNode<T> z = new SkipListNode<>(key, null);
            insertNode(p, z);
            z.down = q;
            q.up = z;
            //把指针移到上一层
            q = z;
            currentLevel++;
        }
        size++;
    }

    /**
     * 如果传入的key值在跳跃表中不存在，则findNode返回跳跃表中key值小于key，并且key值相差最小的底层节点;
     * 所以不能用此方法来代替get
     * @param key key
     * @return key值相差最小的底层节点
     */
    public SkipListNode<T> findNode(int key) {
        SkipListNode<T> p = head;
        while (true) {
            while (p.next.key != SkipListNode.TAIL_KEY && p.next.key <= key) {
                p = p.next;
            }
            //转入下层
            if (p.down != null) {
                p = p.down;
            } else {
                break;
            }
        }
        return p;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 添加新的一层
     */
    public void addEmptyLevel() {
        SkipListNode<T> p1 = new SkipListNode<T>(SkipListNode.HEAD_KEY, null);
        SkipListNode<T> p2 = new SkipListNode<T>(SkipListNode.TAIL_KEY, null);
        p1.next = p2;
        p1.down = head;
        p2.pre = p1;
        p2.down = tail;
        head.up = p1;
        tail.up = p2;
        head = p1;
        tail = p2;
        listLevel++;
    }

    /**
     * 单层插入
     * @param p 前驱
     * @param q 待插入的节点
     */
    private void insertNode(SkipListNode<T> p, SkipListNode<T> q) {
        q.next = p.next;
        q.pre = p;
        p.next.pre = q;
        p.next = q;
    }

    public int getLevel() {
        return listLevel;
    }
}