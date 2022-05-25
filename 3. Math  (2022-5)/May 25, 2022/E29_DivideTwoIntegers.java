import java.util.Map;

public class E29_DivideTwoIntegers {
    //我的 不知道移位操作 超时了
    public int divide(int dividend, int divisor) {
        //2^31 = 2147483648
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        boolean isPositiveDivident = dividend > 0 ? true : false;
        boolean isPositiveDivisot = divisor > 0 ? true : false;
        // corner case 很烦
        if (divisor == 1 || divisor == -1) {
            return divisor == 1 ? dividend : 0-dividend;
        }
        dividend = dividend > 0 ? dividend : 0-dividend;
        divisor = divisor > 0 ? divisor : 0-divisor;
        if (dividend < divisor) {
            return 0;
        } else if (dividend == divisor) {
            return isPositiveDivident ^ isPositiveDivisot ? -1 : 1;
        } else {
            int res = 0;
            String dividentStr = String.valueOf(dividend);
            String divisorStr = String.valueOf(divisor);
            if (dividentStr.length() == divisorStr.length()) {
                int digits = 1;
                int temp = divisor;
                while (temp < dividend) {
                    temp += divisor;
                    digits++;
                }
                if (temp > dividend) {
                    digits--;
                }
                return isPositiveDivident ^ isPositiveDivisot ? 0 - digits : digits;
            } else {
                int k = dividentStr.length() - divisorStr.length();
                StringBuilder sb = new StringBuilder(divisorStr);
                for (int i = 0; i < k; i++) {
                    sb.append('0');
                }
                int temp = Integer.parseInt(sb.toString());
                int curr = 0;
                int num = 0;
                StringBuilder resNum = new StringBuilder();
                while (k >= 0) {
                    if (curr + temp < dividend) {
                        num ++;
                        curr += temp;
                    } else if (curr + temp == dividend) {
                        num ++;
                        resNum.append(num);
                        for (int i = 0 ; i < k; i++) {
                            resNum.append('0');
                        }
                        break;
                    } else {
                        resNum.append(num);
                        num = 0;
                        k--;
                        if (k < 0) {
                            continue;
                        }
                        if (k == 0) {
                            temp = divisor;
                        } else {
                            temp = Integer.parseInt(sb.substring(0, divisorStr.length() + k));
                        }
                    }
                }
                num = Integer.parseInt(resNum.toString());
                return isPositiveDivident^isPositiveDivisot ? 0 - num : num;
                }
        }
    }

    //同样的思路 知道了移位操作 没超时
    public int divide2(int dividend, int divisor) {
        //2^31 = 2147483648
        // corner case 很烦
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        if (divisor == 1 || divisor == -1) {
            return divisor == 1 ? dividend : 0-dividend;
        }

        boolean isPositiveDivident = dividend > 0 ? true : false;
        boolean isPositiveDivisot = divisor > 0 ? true : false;
        dividend = dividend > 0 ? 0-dividend : dividend;
        divisor = divisor > 0 ? 0-divisor : divisor;
        if (dividend > divisor) {
            return 0;
        } else {
            int temp = divisor;
            int times = 1;
            while (temp > dividend && temp >= -1073741824) {
                temp = temp << 1;
                times = times << 1;
            }
            if (temp == dividend) {
                return isPositiveDivident^isPositiveDivisot ? 0 - times : times;
            } else if (temp < dividend) {
                temp = temp >> 1;
                times = times >> 1;
            }
            int res = times;
            int now = dividend - temp;
            temp = temp >> 1;
            times = times >> 1;
            while (times >= 1) {
                if (now < temp) {
                    res += times;
                    now -= temp;
                    times = times >> 1;
                    temp = temp>> 1;
                } else if (now == temp) {
                    res += times;
                    break;
                } else {
                    times = times >> 1;
                    temp = temp >> 1;
                }
            }
            return isPositiveDivident^isPositiveDivisot ? 0 - res : res;
        }

    }

    //快速乘法模板
    private int sqr (int x, int y) {
        int res = 0;
        while (y > 0) {
            if ((y & 1) == 1) {
                res += x;
            }
            y >>= 1;
            x += x;
        }
        return res;

    }



    public static void main(String[] args) {
        int num1 = 21;
        int num2 = 2;
        E29_DivideTwoIntegers temp = new E29_DivideTwoIntegers();
        int res = temp.divide2(num1, num2);
        System.out.println(res);

    }

}
