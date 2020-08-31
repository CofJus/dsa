package tree;

/**
 * 线索树节点类
 * @author Ji Rui
 * @date 2020/8/29 15:12
 */
public class TreeNode {
    int val;
    TreeNode left;
    boolean leftIsThread;
    TreeNode right;
    boolean rightIsThread;

    public TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.leftIsThread = false;
        this.right = null;
        this.rightIsThread = false;
    }
}
