import java.util.HashSet;
import java.util.Set;

/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-05-27 23:02
 */
public class E202_HappyNumber {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        int num = n;
        while (true) {
            int res = 0;
            while (num > 0) {
                int digit = num % 10;
                res += digit * digit;
                num /= 10;
            }
            if (res == 1) {
                return true;
            } else {
                if (set.contains(res)) {
                    return false;
                } else {
                    set.add(res);
                    num = res;
                }
            }
        }
    }

    //快慢指针 鉴定链表是否存在环
    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }


    public static void main(String[] args) {
        int test = 19;
        E202_HappyNumber temp = new E202_HappyNumber();
        boolean res = temp.isHappy2(2);
        System.out.println(res);
    }
}
