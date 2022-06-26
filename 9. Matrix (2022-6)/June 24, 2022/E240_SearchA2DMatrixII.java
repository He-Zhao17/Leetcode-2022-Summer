public class E240_SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if ( target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        int l = 0;
        int r = matrix.length - 1;
        while ( l < r ) {
            int mid = l + (r - l) / 2;
            if (target > matrix[mid][0]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int down = -1;
        if (target >= matrix[l][0]) {
            down = l;
        } else {
            down = l - 1;
        }
        l = 0;
        r = matrix.length - 1;
        while ( l < r) {
            int mid = l + (r - l) / 2;
            if ( matrix[mid][matrix[0].length - 1] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int up = -1;
        if (target <= matrix[l][matrix[0].length - 1]) {
            up = l;
        } else {
            up = l + 1;
        }
        l = 0;
        r = matrix[0].length - 1;
        while ( l < r) {
            int mid = l + (r - l) / 2;
            if (matrix[up][mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int right = -1;
        if (matrix[up][l] > target) {
            right = l - 1;
        } else {
            right = l;
        }
        l = 0;
        r = matrix[0].length - 1;
        while ( l < r) {
            int mid = l + (r - l) / 2;
            if (matrix[down][mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int left = -1;
        if (matrix[down][l] < target) {
            left = l + 1;
        } else {
            left = l;
        }
        for (int i = up; i <= down; ++i) {
            for (int j = left; j <= right; ++j) {
                int temp = matrix[i][j];
                if (temp == target) {
                    return true;
                }
                if (temp > target) {
                    break;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {-1, 3}
                /*{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}*/
        };
        E240_SearchA2DMatrixII temp = new E240_SearchA2DMatrixII();
        temp.searchMatrix(matrix, -1);
    }
}
