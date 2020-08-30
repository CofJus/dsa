package stack.maze;

import java.util.LinkedList;

/**
 * 专用于存放位置信息的队列
 * @author Ji Rui
 * @date 2020/8/30 10:20
 */
public class PosQueue {

    LinkedList<Position> linkedList;

    public PosQueue() {
        linkedList = new LinkedList<>();
    }

    public void add(Position position) {
        linkedList.add(position);
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * 返回并弹出队首元素
     * @return 队首元素
     */
    public Position poll() {
        Position position = linkedList.get(0);
        linkedList.removeFirst();
        return position;
    }
}
