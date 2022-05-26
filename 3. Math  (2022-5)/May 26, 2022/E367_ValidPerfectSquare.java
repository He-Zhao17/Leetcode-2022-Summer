public class E367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        //2147483648
        int l = 1;
        int r = num;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long temp = quikMul(mid, 2);
            long temp1;
            if (temp < (long) num) {
                temp1 = quikMul(mid + 1, 2);
                if (temp1 < (long) num) {
                    l = mid + 1;
                } else if (temp1 == (long) num) {
                    return true;
                } else {
                    return false;
                }
            } else if (temp == (long) num) {
                return true;
            } else {
                temp1 = quikMul(mid - 1, 2);
                if (temp1 > (long) num) {
                    r = mid - 1;
                } else if (temp1 == (long) num) {
                    return true;
                } else {
                    return false;
                }

            }
        }
        return false;
    }

    private long quikMul (int x, int n) {
        long ans = 1;
        long x_con = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= x_con;
            }
            x_con *= x_con;
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        E367_ValidPerfectSquare temp = new E367_ValidPerfectSquare();
        boolean res = temp.isPerfectSquare(16);
        long mul = temp.quikMul(8, 8);
        System.out.println(res);
    }
}
