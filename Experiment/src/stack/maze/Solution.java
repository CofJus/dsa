package stack.maze;

import java.util.Stack;

/**
 * @author Ji Rui
 * @date 2020/8/29 16:46
 */
public class Solution {

    /**
     * 9*9的迷宫
     * 规定，(0,0)为起点，(8,8)为终点
     * 0代表可通过，1代表不可通过
     */
    int[][] maze = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 1, 1, 0, 1, 0},
            {1, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 1, 0, 1},
            {1, 1, 0, 0, 0, 1, 1, 0, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 0}
    };

    /** 标记是否已经访问过 */
    int[][] vis = new int[9][9];

    /** 方向数组 */
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    /** 上一个点 */
    Position[][] father = new Position[9][9];

    /** 上一次走的方向 */
    int[][] lastDir = new int[9][9];

    /** 从起点开始的最短距离 */
    int[][] dist = new int[9][9];

    private final static String dir = "UDLR";
    private final static int ROW = 9;
    private final static int COL = 9;

    public void bfs() {
        PosQueue q = new PosQueue();
        //起点的上一个点是其本身
        Position position = new Position(0, 0);
        father[0][0] = position;
        //置起点为已访问过
        vis[position.x][position.y] = 1;
        q.add(position);
        while (!q.isEmpty()) {
            Position cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                //判断是否越界和是否已经走过
                if (x >= 0 && x < ROW && y >= 0 && y < COL && 0 == vis[x][y] && 0 == maze[x][y]) {
                    Position p = new Position(x, y);
                    vis[x][y] = 1;
                    father[x][y] = cur;
                    dist[x][y] = dist[cur.x][cur.y] + 1;
                    lastDir[x][y] = i;
                    q.add(p);
                    //System.out.println("("+p.x+", "+p.y+")");
                }
            }
        }
    }

    /** 回溯并打印路径 */
    public void showPath() {
        //从终点开始回溯路径，并存放在栈中
        int row = ROW - 1;
        int col = COL - 1;
        Stack<Character> path = new Stack<>();
        while (true) {
            int pRow = father[row][col].x;
            int pCol = father[row][col].y;
            if (0 == pRow && 0 == pCol) {
                break;
            } else {
                path.push(dir.charAt(lastDir[pRow][pCol]));
                row = pRow;
                col = pCol;
            }
        }
        while (!path.isEmpty()) {
            System.out.print(path.pop());
        }
    }
}