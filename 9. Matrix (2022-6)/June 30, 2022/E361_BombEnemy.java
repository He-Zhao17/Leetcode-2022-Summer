public class E361_BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        int[][] horizon = new int[grid.length][grid[0].length];
        int[][] vertical = new int[grid.length][grid[0].length];
        int max = 0;


        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '0') {
                    int k = j - 1;
                    boolean isCal = false;
                    int lE = 0;
                    while (k >= 0) {
                        if (grid[i][k] == '0') {
                            isCal = true;
                            break;
                        } else if (grid[i][k] == 'W') {
                            isCal = false;
                            break;
                        } else {
                            lE++;
                        }
                        k--;
                    }
                    if (isCal) {
                        horizon[i][j] = horizon[i][k];
                    } else {
                        int sum = lE;
                        k = j + 1;
                        while (k < grid[0].length) {
                            if (grid[i][k] == 'E') {
                                sum++;
                            } else if (grid[i][k] == 'W') {
                                break;
                            }
                            k++;
                        }
                        horizon[i][j] = sum;
                    }
                    k = i - 1;
                    isCal = false;
                    lE = 0;
                    while (k >= 0) {
                        if (grid[k][j] == '0') {
                            isCal = true;
                            break;
                        } else if (grid[k][j] == 'W') {
                            break;
                        } else {
                            lE++;
                        }
                        k--;
                    }
                    if (isCal) {
                        vertical[i][j] = vertical[k][j];
                    } else {
                        int sum = lE;
                        k = i + 1;
                        while (k < grid.length) {
                            if (grid[k][j] == 'E') {
                                sum++;
                            } else if (grid[k][j] == 'W') {
                                break;
                            }
                            k++;
                        }
                        vertical[i][j] = sum;
                    }
                    int sum = vertical[i][j] + horizon[i][j];
                    max = max > sum ? max : sum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'0','E','0','0'},
                {'E','0','W','E'},
                {'0','E','0','0'}
        };
        E361_BombEnemy temp = new E361_BombEnemy();
        int res = temp.maxKilledEnemies(grid);
        System.out.println(res);
    }
}
