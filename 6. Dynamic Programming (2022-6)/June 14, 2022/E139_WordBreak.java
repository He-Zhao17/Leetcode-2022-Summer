import java.util.Arrays;
import java.util.List;

public class E139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        outer1:
        for (int i = 1; i <= len; ++i) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j]) {
                    String str = i - 1 == s.length() - 1 ? s.substring(j) : s.substring(j, i);
                    if (wordDict.contains(str)){
                        dp[i] = true;
                        continue outer1;
                    }
                }
            }
        }
        return dp[len];


    }
}
