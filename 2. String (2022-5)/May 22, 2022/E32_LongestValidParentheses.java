import java.util.Stack;

public class E32_LongestValidParentheses {

    //常规用栈是解不出来的 因为无法判断一个'(' 打断与否
    // 动态规划 答案
    public int longestValidParentheses(String s) {
        if(s.length() <= 1) {
            return 0;
        }
        // 冬天规划矩阵 此时的最长字串
        int dp[] = new int[s.length()];
        dp[0] = 0;
        int max = 0;

        for (int i = 1; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                dp[i] = 0;
                if (max < dp[i]) {
                    max = dp[i];
                }
            } else {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i == 1 ? 2 : dp[i - 2] + 2;
                    if (max < dp[i]) {
                        max = dp[i];
                    }
                } else {
                    int k = dp[i - 1];
                    dp[i] = s.charAt(i - k - 1) == '(' ? (i - k - 2 < 0 ? dp[i - 1] + 2 : dp[i - 1] + dp[i - k - 2] + 2) : 0;

                    if (max < dp[i]) {
                        max = dp[i];
                    }
                }
            }
        }
        return max;


    }

    //骚操作 答案
    public int longestValidParentheses2 (String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                l++;
            } else {
                r++;
                if (l == r) {
                    max = max < 2*l ? 2*l : max;
                } else if (r > l) {
                    l = 0;
                    r = 0;
                }
            }
        }
        //反方向再来一次 因为一次会忽略"(()"的情况
        l = r = 0;
        for (int i = s.length() - 1; i > -1; --i) {
            char ch = s.charAt(i);
            if (ch == ')') {
                r++;
            } else {
                l++;
                if (l == r) {
                    max = max < 2 * l ? 2 * l : max;
                } else if (l > r){
                    l = r = 0;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String test = "(()())";
        E32_LongestValidParentheses temp = new E32_LongestValidParentheses();
        int res = temp.longestValidParentheses(test);
        System.out.println(res);
    }

}
