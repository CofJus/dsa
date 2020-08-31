package libiary;

/**
 * @author Ji Rui
 * @date 2020/8/30 18:59
 */
public class SkipListNode<T> {

    /** 关键码 */
    public int key;

    /** 数据域 */
    public T value;

    /** 前驱、后继 */
    public SkipListNode<T> pre, next;

    /** 上邻、下邻 */
    public SkipListNode<T> up, down;

    public static final int HEAD_KEY = Integer.MIN_VALUE;
    public static final int TAIL_KEY = Integer.MAX_VALUE;

    public SkipListNode(int k, T v) {
        key = k;
        value = v;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof SkipListNode<?>)) {
            return false;
        }
        SkipListNode<T> skipListNode;
        try {
            skipListNode = (SkipListNode<T>) object;
        } catch (ClassCastException ex) {
            return false;
        }
        return (skipListNode.getKey() == key) && (skipListNode.getValue() == value);
    }

    @Override
    public String toString() {
        return "key-value:" + key + "," + value;
    }
}