import java.util.ArrayList;
import java.util.Arrays;

public class E204_CountPrimes {
    //会超时
    ArrayList<Integer> primes = new ArrayList<>();
    public int countPrimes(int n) {
        if (n <= 1 ){
            return 0;
        }
        int res = 0;
        outer1:
        for (int i = 2; i < n ; ++i) {
            for (int k = 0; k < primes.size(); k++) {
                if (i % primes.get(k) == 0) {
                    continue outer1;
                }
            }
            int start = primes.size() == 0 ? 2 : primes.get(primes.size() - 1) + 1;

            for (int j = start; j * j <= i; ++j) {
                if (i % j == 0) {
                    continue outer1;
                }
            }
            res++;
            primes.add(i);
        }
        return res;
    }

    //埃氏筛
    public int countPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans++;
            }
            //注意溢出
            if ((long) i * i < n) {
                for (int j = i* i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }

        }
        return ans;
    }

    //线性筛
    public int countPrimes3 (int n) {
        int res = 0;
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 2; i < n; i++ ){
            if (isPrime[i] == 1) {
                arr.add(i);
            }
            //注意isPrime的越界
            for (int j = 0; j < arr.size() && i * arr.get(j) < n; ++j) {
                isPrime[arr.get(j) * i] = 0;
                if (i % arr.get(j) == 0) {
                    break;
                }
            }
        }
        return arr.size();
    }

    //对于合数 n，我们可以证明它一定有一个小于等于 [公式] 的非平凡因数。这里的非平凡因数，指的是和1与他本身不同的因数。
    //如果不是，那么它所有的非平凡因数都是大于 [公式] 的。我们任取其中一个和n不同的非平凡因数 m，那么存在整数 k 使 n=km，那么 k 也为 n 的非平凡因数，但是 [公式] ，矛盾。所以合数 n 一定有一个小于等于 [公式] 的非平凡因数。
    private boolean isPrime (int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n ; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        primes.add(n);
        return true;
    }

    public static void main(String[] args) {
        int test = 10;
        E204_CountPrimes temp = new E204_CountPrimes();
        int res = temp.countPrimes(test);
        System.out.println(res);
    }
}
