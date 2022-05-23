import java.util.HashMap;

public class E115_DistinctSubsequences {
    //答案 动态规划
    public int numDistinct2(String s, String t) {
        //corner case
        if (s.length() < t.length()) {
            return 0;
        } else if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != t.charAt(i)) {
                    return 0;
                }
            }
            return 1;
        }


        int[][] dp = new int[s.length()][t.length()];
        int tail = s.length() - 1;
        for (int i = 0; i < t.length(); ++i) {
            if (t.length() - i == 1 && s.charAt(tail) == t.charAt(t.length() - 1)) {
                dp[tail][i] = 1;
            } else {
                dp[tail][i] = 0;
            }
        }
        tail = t.length() - 1;
        for (int i = 0; i < s.length(); ++i) {
            int temp = 0;
            for (int j = i; j < s.length(); ++j) {
                if (s.charAt(j) == t.charAt(tail)) {
                    temp++;
                }
            }
            dp[i][tail] = temp;
        }
        //如果 s[i]s[i] 和 t[j]t[j] 匹配，则考虑 t[j+1:]t[j+1:] 作为 s[i+1:]s[i+1:] 的子序列，子序列数为 \textit{dp}[i+1][j+1]dp[i+1][j+1]；
        //
        //如果 s[i]s[i] 不和 t[j]t[j] 匹配，则考虑 t[j:]t[j:] 作为 s[i+1:]s[i+1:] 的子序列，子序列数为 \textit{dp}[i+1][j]dp[i+1][j]。
        for (int i = s.length() - 2; i >= 0; --i) {
            for (int j = 0; j < t.length() - 1; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }






    //说白了就是回溯/DFS会超时
    //Hashmap会超时？
    //看了答案应该用dp[i][j]
    HashMap<sGroup, Integer> map = new HashMap<>();
    class sGroup {
        String s;
        String t;
        public sGroup(String s, String t) {
            this.s = s;
            this.t = t;
        }

        public boolean equals (Object kk) {
            if (((sGroup) kk).s == this.s && ((sGroup) kk).t == this.t) {
                return true;
            } else {
                return false;
            }
        }
    }


    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }

        int res = helper(s, t);
        return res;
    }

    private int helper (String s, String t) {
        if (t.length() == 0) {
            return 1;
        } else {
            if (s.length() == 0) {
                return 0;
            }
        }
        if (map.containsKey(new sGroup(s, t))) {
            return map.get(new sGroup(s, t));
        }
        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); ++i) {
                char ch1 = s.charAt(i);
                char ch2 = t.charAt(i);
                if (ch1 != ch2) {
                    return 0;
                }
            }
            return 1;
        }
        int sIndex = 0;
        int tIndex = 0;
        int num = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.length() - sIndex < t.length() - tIndex) {
                return num;
            }
            char chS = s.charAt(sIndex);
            char chT = t.charAt(tIndex);
            if (chS == chT) {
                StringBuilder sbs = new StringBuilder();
                sbs.append(sIndex == s.length() - 1 ? "" : s.substring(sIndex + 1));
                String ss = sbs.toString();
                String st = t.length() == 1 ? "" : t.substring(1);
                int res = helper(ss, st);
                map.put(new sGroup(ss, st), res);
                num += res;
                sIndex++;
            } else {
                sIndex++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        E115_DistinctSubsequences temp = new E115_DistinctSubsequences();
        int res = temp.numDistinct2(s, t);
        System.out.println(res);
    }

}
