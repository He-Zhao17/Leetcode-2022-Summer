import java.util.HashMap;

public class E50_PowXN {
    //我的 会超时 ps有点太严格了

    public double myPow(double x, int n) {
        if (n == 0 ){
            return 1.0;
        }
        Boolean isPosiN = n > 0 ? true: false;
        n = isPosiN ? n : 0 - n;

        HashMap<Integer, Double> map = new HashMap<>();
        map.put(1, x);

        double temp = x;
        int times = 1;
        while (2 * times <= n) {
            temp = temp * temp;
            times *= 2;
            map.put(times, temp);
        }
        n -= times;
        double res = temp;
        times /= 2;
        while (n > 0) {
            if (n > times) {
                res *= map.get(times);
                n -= times;
                times /= 2;
            } else if (n == times) {
                res *= map.get(times);
                break;
            } else {
                times /= 2;
            }
        }
        return isPosiN ? res : 1.0 / res;
    }

    //答案 也可以递归 但是这个更秒
    public double myPow2 (double x, int n) {
        //防止边界溢出
        long N = n;
        return N > 0 ? quikMul(x, N) : 1.0 / quikMul(x, N);

    }

    private double quikMul (double x, long N) {
        double ans = 1.0;
        double x_contribute = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            N /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        E50_PowXN temp = new E50_PowXN();
        double res = temp.myPow(0.00001,
                2147483647);
        System.out.println(res);
    }

}
