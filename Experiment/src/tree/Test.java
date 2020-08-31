package tree;

/**
 * 线索二叉树测试类
 * @author Ji Rui
 * @date 2020/8/29 16:19
 */
public class Test {
    public static void main(String[] args) {

        //创建树
        BinarySearchTree binarySearchTree = new BinarySearchTree(new TreeNode(5));

        //插入节点
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.insert(8);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        binarySearchTree.insert(1);
        binarySearchTree.insert(9);

        //中序遍历
        binarySearchTree.print(binarySearchTree.root);

        //中序线索化
        binarySearchTree.makeThread(binarySearchTree.root);

        System.out.println("---Thread---");

        //线索化后遍历
        binarySearchTree.traverseWithThread();
    }
}
