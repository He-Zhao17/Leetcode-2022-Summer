public class E174_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int r = dungeon.length;
        int c = dungeon[0].length;
        dp[r - 1][c - 1] = dungeon[r - 1][c - 1] > 0 ? 0 : dungeon[r - 1][c - 1];
        for (int i = c - 2; i >= 0; i--) {
            dp[r - 1][i] = dp[r - 1][i + 1] + dungeon[r - 1][i] > 0 ? 0 : dp[r - 1][i + 1] + dungeon[r - 1][i];
        }
        for (int i = r - 2; i >= 0; --i) {
            dp[i][c - 1] = dp[i + 1][c - 1] + dungeon[i][c - 1] > 0 ? 0 : dp[i + 1][c - 1] + dungeon[i][c - 1];
        }
        for (int i = r - 2; i >= 0; --i) {
            for (int j = c - 2; j >= 0; --j) {
                int m = Math.max(dp[i + 1][j] + dungeon[i][j], dp[i][j + 1] + dungeon[i][j]);
                dp[i][j] = m > 0 ? 0 : m;
            }
        }
        return -dp[0][0] + 1;
    }

    public static void main(String[] args) {
        E174_DungeonGame temp = new E174_DungeonGame();
        int[][] duengon = new int[][] {{1, -3, 3}, {0, -2, 0},{-3, -3, -3}};
        temp.calculateMinimumHP(duengon);
    }
}
