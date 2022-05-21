import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class E5_LongestPalindromicSubstring {
    //我的答案 中心扩散
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int max = 0;
        String res = "";


        int curr = 1;

        while (curr < s.length()) {
            if (s.charAt(curr) == s.charAt(curr - 1)) {
                int l = curr - 2;
                int r = curr + 1;
                while (l >= 0 && r < s.length()) {
                    if (s.charAt(l) == s.charAt(r)) {
                        l--;
                        r++;
                    } else {
                        break;
                    }
                }
                if (r == s.length()) {
                    if (l < 0) {
                        return s;
                    } else {
                        if (max < r - l - 1) {
                            max = r - l - 1;
                            res = s.substring(l + 1);
                        }
                    }
                } else {
                    if (l < 0) {
                        if (max < r) {
                            max = r;
                            res = s.substring(0, r);
                        }
                    } else {
                        if (max < r - l - 1) {
                            max = r - l - 1;
                            res = s.substring(l + 1, r);
                        }
                    }
                }
            }

            ///
            if (curr > 1 && s.charAt(curr) == s.charAt(curr - 2)) {
                int l = curr - 3;
                int r = curr + 1;
                while (l >= 0 && r < s.length()) {
                    if (s.charAt(l) == s.charAt(r)) {
                        l--;
                        r++;
                    } else {
                        break;
                    }
                }
                if (r == s.length()) {
                    if (l < 0) {
                        return s;
                    } else {
                        if (max < r - l - 1) {
                            max = r - l - 1;
                            res = s.substring(l + 1);
                        }
                    }
                } else {
                    if (l < 0) {
                        if (max < r) {
                            max = r;
                            res = s.substring(0, r);
                        }
                    } else {
                        if (max < r - l - 1) {
                            max = r - l - 1;
                            res = s.substring(l + 1, r);
                        }
                    }
                }
            }
            curr++;
        }
        if (res.equals("")) {
            return s.substring(0, 1);
        }
        return res;
    }

    // 答案动态规划1
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        String res = "";
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len - 1; ++i) {
            Arrays.fill(dp[i], false);
        }
        for (int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        char[] charArr = s.toCharArray();

        for (int i = 0; i < len - 1; ++i) {
            if (charArr[i] == charArr[i + 1]) {
                dp[i][i + 1] = true;
                if (maxLen < 2) {
                    maxLen = 2;
                    res = i + 1 == len - 1 ? s.substring(i) : s.substring(i, i + 2);
                }
            } else {
                dp[i][i + 1] = false;
            }
        }
        for (int j = 2; j < len; ++j) {
            int j1 = j;
            for (int i = 0; i < len - j; ++i ){
                dp[i][j1] = dp[i + 1][j1 - 1] && (charArr[i] == charArr[j1]);
                if (dp[i][j1] && maxLen < j1 - i + 1) {
                    maxLen = j1 - i + 1;
                    res = j1 == len - 1 ? s.substring(i) : s.substring(i, j1 + 1);
                }
                j1++;
            }
        }
        if (maxLen == 1) {
            return s.substring(0, 1);
        }
        return res;

    }

    //拓展 Manacher算法  ===第二遍复习再学习把面试也不考
    public String longestPalindrome3(String s) {

        return s;
    }

    public static void main(String[] args) {
        String test = "cbbd";
        E5_LongestPalindromicSubstring temp = new E5_LongestPalindromicSubstring();
        String res = temp.longestPalindrome2(test);
        System.out.println(res);
    }
}
