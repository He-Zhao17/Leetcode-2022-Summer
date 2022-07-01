import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class E79_WordSearch {
    boolean[][] map;
    public boolean exist(char[][] board, String word) {
        map = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            Arrays.fill(map[i], false);
        }
        char[] arr = word.toCharArray();
        char a = arr[0];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; ++j) {
                char t = board[i][j];
                if (t == a) {
                    map[i][j] = true;
                    boolean res = help (board, i, j, 0, arr);
                    if (res) {
                        return true;
                    } else {
                        map[i][j] = false;
                    }
                }
            }
        }
        return false;
    }
    private boolean help (char[][] board, int i, int j, int index, char[] arr) {
        if (index == arr.length - 1) {
            return  true;
        } else {
            if (i - 1 >= 0 && !map[i - 1][j]) {
                if (board[i - 1][j] == arr[index + 1]) {
                    map[i - 1][j] = true;
                    boolean t = help(board, i - 1, j, index + 1, arr);
                    if (t) {
                        return true;
                    } else {
                        map[i - 1][j] = false;
                    }
                }
            }
            if (j + 1 < board[0].length && !map[i][j + 1]) {
                if (board[i][j + 1] == arr[index + 1]) {
                    map[i][j + 1] = true;
                    boolean t = help(board, i, j + 1, index + 1, arr);
                    if (t) {
                        return true;
                    } else {
                        map[i][j + 1] = false;
                    }
                }
            }
            if (i + 1 < board.length && !map[i + 1][j]) {
                if (board[i + 1][j] == arr[index + 1]) {
                    map[i + 1][j] = true;
                    boolean t = help(board, i + 1, j, index + 1, arr);
                    if (t) {
                        return true;
                    } else {
                        map[i + 1][j] = false;
                    }

                }
            }
            if (j - 1 >= 0 && !map[i][j - 1]) {
                if (board[i][j - 1] == arr[index + 1]) {
                    map[i][j - 1] = true;
                    boolean t = help(board, i , j - 1, index + 1, arr);
                    if (t) {
                        return true;
                    } else {
                        map[i][j - 1] = false;
                    }
                }
            }
            return false;
        }
    }
}
