import java.util.concurrent.ConcurrentHashMap;

public class E65_ValidNumber {
    //我的答案 很快
    public boolean isNumber(String s) {
        int eindex = -1;
        int numsE = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                eindex = i;
                numsE++;
            }
        }
        if (numsE == 0) {
            return isDecimal(s);

        } else if (numsE > 1) {
            return false;
        } else {
            if (eindex == 0 || eindex == s.length() - 1) {
                return false;
            } else {
                String f = s.substring(0, eindex);
                String t = s.substring(eindex + 1);
                boolean fb = isDecimal(f);
                boolean tb = isInteger(t);
                return fb & tb;
            }
        }

    }
    //答案： 其实这道题想用DFA状态转移矩阵 理解思想 大型分类讨论而已
    public int make(char c) {
        switch(c) {
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            case 'E': return 4;
            default:
                if(c >= 48 && c <= 57) return 2;
        }
        return -1;
    }

    public boolean isNumber2(String s) {
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]{{ 0, 1, 6, 2,-1},
                {-1,-1, 6, 2,-1},
                {-1,-1, 3,-1,-1},
                { 8,-1, 3,-1, 4},
                {-1, 7, 5,-1,-1},
                { 8,-1, 5,-1,-1},
                { 8,-1, 6, 3, 4},
                {-1,-1, 5,-1,-1},
                { 8,-1,-1,-1,-1}};
        char[] ss = s.toCharArray();
        for(int i=0; i < ss.length; ++i) {
            int id = make(ss[i]);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) > 0;
    }


    private boolean isInteger (String s) {
        int start = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.length() == 1) {
                return false;
            } else {
                start = 1;
            }
        }

        for (int i = start; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isDecimal (String s) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.length() == 1) {
                return false;
            } else {
                s = s.substring(1);
            }
        }


        int numsD = 0;
        for (int i = 0; i < s.length(); ++i) {

            if (s.charAt(i) == '.') {
                if (s.length() == 1) {
                    return false;
                }
                if (numsD == 0) {
                    numsD++;
                } else {
                    return false;
                }
            } else if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }


}
