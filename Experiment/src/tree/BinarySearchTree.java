package tree;

/**
 * 二叉搜索树
 * @author Ji Rui
 * @date 2020/8/29 15:12
 */
public class BinarySearchTree {
    TreeNode root;

    TreeNode pre = null;

    BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    /**
     * 插入
     * @param val 待插入的值，不重复
     */
    public void insert(int val) {
        if(null == root) {
            root = new TreeNode(val);
        }
        else {
            TreeNode p = root;
            TreeNode pre;
            while(true) {
                pre = p;
                if(val < p.val) {
                    p = p.left;
                    if(null == p)
                    {
                        pre.left = new TreeNode(val);
                        return;
                    }
                }
                else if(val > p.val) {
                    p = p.right;
                    if(null == p)
                    {
                        pre.right = new TreeNode(val);
                        return;
                    }
                }
            }
        }
    }

    /**
     * 中序遍历
     * @param node 传入根节点，BinarySearchTree.root
     */
    public void print(TreeNode node) {
        if(null != node.left) {
            print(node.left);
        }
        System.out.println(node.val);
        if(null != node.right) {
            print(node.right);
        }
    }

    /**
     * 线索化
     * @param node 传入根节点，BinarySearchTree.root
     */
    public void makeThread(TreeNode node) {
        if(null == node) {
            return;
        }

        makeThread(node.left);

        if (node.left == null) {
            node.left = pre;
            node.leftIsThread = true;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightIsThread = true;
        }
        pre = node;

        makeThread(node.right);
    }

    /**
     * 线索化后遍历
     */
    public void traverseWithThread() {
        TreeNode node = root;
        while (node != null) {
            while (!node.leftIsThread) {
                node = node.left;
            }
            System.out.println(node.val);
            while (node.rightIsThread) {
                node = node.right;
                System.out.println(node.val);
            }
            node = node.right;
        }
    }
}
