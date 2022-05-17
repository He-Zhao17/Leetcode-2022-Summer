import java.util.Stack;

public class E273_IntegerToEnglishWord {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};


    //我的答案 注意溢出！！！
    public String numberToWords(int num) {
        int i = 1;
        Stack<String> sta = new Stack<>();
        while (i <= 4) {
            StringBuilder sb = new StringBuilder();
            //!!!!!!!!!!!!!注意 1000^4 会越界 int 的overflow
            int temp = 0;
            if (i < 4) {
                temp = ((num % ((int) Math.pow(1000, i)))) / ((int) Math.pow(1000, i - 1));
            } else {
                temp = num / ((int) Math.pow(1000, i - 1));
            }
            int single = temp % 10;
            int ten = ((temp - single) % 100) / 10;
            int hundred = (temp - single - ten * 10) / 100;
            if(hundred > 0) {
                sb.append(singles[hundred] + " ");
                sb.append("Hundred");
            }
            if (ten > 0) {
                if (hundred > 0) {
                    sb.append(" ");
                }
                if (ten == 1) {
                    sb.append(teens[single]);
                } else {
                    sb.append(tens[ten]);
                    if (single > 0) {
                        sb.append(" " + singles[single]);
                    }
                }
            } else {
                if (hundred > 0 && single > 0) {
                    sb.append(" ");
                }
                sb.append(singles[single]);
            }
            if (sb.length() > 0) {
                if (i > 1) {
                    sb.append(" " + thousands[i - 1]);

                }
                sta.push(sb.toString());
            }
            ++i;
        }
        StringBuilder sb = new StringBuilder();
        if (sta.size() == 0) {
            return "Zero";
        } else {
            int temp3 = sta.size() - 1;
            for (int k = 0; k < temp3; ++k) {
                sb.append(sta.pop());
                sb.append(" ");
            }
            sb.append(sta.pop());
            return sb.toString();
        }

    }

    //答案：递归 （并不一定比我的快）
    public String numberToWords2(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                StringBuffer curr = new StringBuffer();
                recursion(curr, curNum);
                curr.append(thousands[i]).append(" ");
                sb.append(curr);
            }
        }
        return sb.toString().trim();
    }

    public void recursion(StringBuffer curr, int num) {
        if (num == 0) {
            return;
        } else if (num < 10) {
            curr.append(singles[num]).append(" ");
        } else if (num < 20) {
            curr.append(teens[num - 10]).append(" ");
        } else if (num < 100) {
            curr.append(tens[num / 10]).append(" ");
            recursion(curr, num % 10);
        } else {
            curr.append(singles[num / 100]).append(" Hundred ");
            recursion(curr, num % 100);
        }
    }



    public static void main(String[] args) {
        E273_IntegerToEnglishWord temp = new E273_IntegerToEnglishWord();
        temp.numberToWords(2147483647);

    }
}



