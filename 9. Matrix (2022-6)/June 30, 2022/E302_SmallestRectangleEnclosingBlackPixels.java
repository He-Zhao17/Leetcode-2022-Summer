import java.util.Arrays;

public class E302_SmallestRectangleEnclosingBlackPixels {
    int up, down, left, right;
    boolean[][] visited;
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(visited[i], false);
        }
        up = x;
        down = x;
        left = y;
        right = y;
        help(x, y, image);
        return (down - up + 1) * (right - left + 1);
    }
    private void help (int x, int y, char[][] image) {
        up = up < x ? up : x;
        down = down > x ? down : x;
        left = left < y ? left : y;
        right = right > y ? right : y;
        visited[x][y] = true;
        if (x - 1 >= 0) {
            if (image[x - 1][y] == '1' && !visited[x - 1][y]) {
                help(x - 1, y, image);
            }
        }
        if ( x + 1 < image.length) {
            if (image[x + 1][y] == '1' && !visited[x + 1][y]) {
                help(x + 1, y , image);
            }
        }
        if (y - 1 >= 0) {
            if (image[x][y - 1] == '1' && !visited[x][y - 1]) {
                help(x, y - 1, image);
            }
        }
        if (y + 1 < image[0].length) {
            if (image[x][y + 1] == '1' && !visited[x][y + 1]) {
                help(x, y + 1, image);
            }
        }
    }
}
