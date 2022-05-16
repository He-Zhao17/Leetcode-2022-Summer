import javax.management.MBeanRegistration;

public class E13_RomanToInteger {


    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0) {
            return 0;
        }
        int point = 0;
        int ch = 0;
        int res = 0;
        while (point < arr.length) {
            //更好的方法是遇到右边比左边大的就加个负号
            switch (arr[point]) {
                case 'I' :
                    if (point + 1 < arr.length) {
                        if (arr[point + 1] == 'V') {
                            ch = 4;
                            point++;
                            break;
                        }
                        if (arr[point + 1] == 'X') {
                            ch = 9;
                            point++;
                            break;
                        }
                        ch = 1;
                        break;
                    } else {
                        ch = 1;
                        break;
                    }
                case 'V' :
                    ch = 5;
                    break;
                case 'X' :
                    if (point + 1 < arr.length && arr[point + 1] == 'L') {
                        ch = 40;
                        point++;
                        break;
                    } else if (point + 1 < arr.length && arr[point + 1] == 'C') {
                        ch = 90;
                        point++;
                        break;
                    } else {
                        ch = 10;
                        break;
                    }
                case 'L' :
                    ch = 50;
                    break;
                case 'C' :
                    if (point + 1 < arr.length && arr[point + 1] == 'D') {
                        ch = 400;
                        point++;
                        break;
                    } else if (point + 1 < arr.length && arr[point + 1] == 'M') {
                        ch = 900;
                        point++;
                        break;
                    } else {
                        ch = 100;
                        break;
                    }
                case 'D' :
                    ch = 500;
                    break;
                case 'M' :
                    ch = 1000;
                    break;
            }
            res += ch;
            point++;

        }
        return res;
    }



    public static void main(String[] args) {
        E13_RomanToInteger temp = new E13_RomanToInteger();
        temp.romanToInt("IX");
    }
}
