/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-05-27 23:57
 */
public class E263_UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        //虽然很奇怪 但是一定要注意溢出
        /*if (n == Integer.MIN_VALUE) {
            n = - (n / 2);
        } else {
            n = n < 0 ? -n : n;
        }*/

        while (n > 6) {
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            if (n % 3 == 0) {
                n /= 3;
                continue;
            }
            if (n % 5 == 0) {
                n /= 5;
                continue;
            }
            break;
        }
        if (n <= 6) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        int test = -2147483648;
        E263_UglyNumber temp = new E263_UglyNumber();
        boolean res = temp.isUgly(test);
        System.out.println(res);
    }

}
