import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-07-11 13:41
 */
public class E286_WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> que = new LinkedList<int[]>();
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[0].length; ++j) {
                if (rooms[i][j] == 0) {
                    que.offer(new int[] {i, j});
                }
            }
        }
        int curr = 0;
        while (que.size() > 0) {
            curr++;
            int size = que.size();
            for (int i = 0; i < size; ++i) {
                int[] temp = que.poll();
                int x = temp[0];
                int y = temp[1];
                if (x - 1 >= 0) {
                    int th = rooms[x - 1][y];
                    if (th > curr) {
                        rooms[x - 1][y] = curr;
                        que.offer(new int[] {x - 1, y});
                    }
                }
                if (y - 1 >= 0) {
                    int ht = rooms[x][y - 1];
                    if (ht > curr) {
                        rooms[x][y - 1] = curr;
                        que.offer(new int[] {x, y - 1});
                    }
                }
                if ( x + 1 < rooms.length) {
                    int ht = rooms[x + 1][y];
                    if (ht > curr) {
                        rooms[x + 1][y] = curr;
                        que.offer(new int[] {x + 1, y});
                    }
                }
                if (y + 1 < rooms[0].length) {
                    int ht = rooms[x][y + 1];
                    if (ht > curr) {
                        rooms[x][y + 1] = curr;
                        que.offer(new int[] {x, y + 1});
                    }
                }
            }

        }

    }

}
