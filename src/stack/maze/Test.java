package stack.maze;

/**
 * 走迷宫测试类
 * @author Ji Rui
 * @date 2020/8/30 10:15
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.bfs();

        System.out.println("------------");

        solution.showPath();

        System.out.println("\n-----END-----");
    }
}
