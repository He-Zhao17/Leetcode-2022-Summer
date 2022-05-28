/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-05-27 22:29
 */
public class E231_PowerOfTwo {
    //位运算1
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if ((n&(n - 1)) == 0) {
            return true;
        } else {
            return false;
        }

    }

    //位运算2
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) {
            return false;
        }
        if ((n&(-n)) == n) {
            return true;
        } else {
            return false;
        }
    }

    //取巧
    public boolean isPowerOfTwo3(int n) {
        if (n <= 0) {
            return false;
        }
        int big = 1 << 30;
        if (big % n == 0) {
            return true;
        } else {
            return false;
        }
    }

}
