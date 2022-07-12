import java.util.Arrays;

/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-07-11 14:21
 */
public class E130_SurroundedRegions {
    boolean[][] isVisited;
    char[][] res;
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        isVisited = new boolean[r][c];
        res = new char[r][c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                res[i][j] = board[i][j];
                board[i][j] = 'X';
            }
        }
        for (int i = 0; i < r; ++i) {
            Arrays.fill(isVisited[i], false);
        }
        for (int i = 0; i < c; i++) {
            if (res[0][i] == 'O') {
                if (isVisited[0][i]) {
                    continue;
                } else {
                    help(board,res, 0, i);
                }
            }
        }
        for (int i = 0; i < c; i++) {
            if (res[r - 1][i] == 'O') {
                if (isVisited[r - 1][i]) {
                    continue;
                } else {
                    help(board,res, r - 1, i);
                }
            }
        }
        for (int i = 1; i < r; i++) {
            if (res[i][0] == 'O') {
                if (isVisited[i][0]) {
                    continue;
                } else {
                    help(board,res, i, 0);
                }
            }
        }
        for (int i = 1; i < r; i++) {
            if (res[i][c - 1] == 'O') {
                if (isVisited[i][c - 1]) {
                    continue;
                } else {
                    help(board,res, i, c - 1);
                }
            }
        }


    }
    private void help (char[][] board,char[][] res,  int i, int j) {
        if (res[i][j] == 'O') {
            if (!isVisited[i][j]) {
                isVisited[i][j] = true;
                board[i][j] = 'O';
                if (i - 1 >= 0) {
                    help(board, res, i - 1, j);
                }
                if (j - 1 >= 0) {
                    help(board,res, i , j - 1);
                }
                if (i + 1 < board.length) {
                    help(board,res, i + 1, j);
                }
                if (j + 1 < board[0].length) {
                    help(board,res, i, j + 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}
        };
        E130_SurroundedRegions temp = new E130_SurroundedRegions();
        temp.solve(board);
    }
}
