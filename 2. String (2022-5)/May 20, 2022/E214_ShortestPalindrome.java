public class E214_ShortestPalindrome {

    //我的答案 暴力比较 太慢了
    public String shortestPalindrome(String s) {
        if (s.length() <= 1 ){
            return s;
        }
        char[] arr = s.toCharArray();
        int end = s.length() - 1;
        int resr = -1;
        outer1:
        while (end >= 0) {
            int l = 0;
            int r = end;
            while (l < r) {
                if (arr[l] != arr[r]) {
                    end--;
                    continue outer1;
                }
            }
            break;
        }
        if (end == s.length() - 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(end + 1));
        sb.reverse();
        sb.append(s);
        return s;


    }

    //答案 KMP算法
    public String shortestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }
        //构建next数组
        int[] next = new int[s.length()];
        next[0] = 0;
        int i = 1;
        int now = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(now)) {
                now++;
                next[i] = now;
                i++;
            } else if (now != 0) {
                now = next[now - 1];
            } else {
                next[i] = now;
                i++;
            }
        }
        //next构建完成

        int r = s.length() - 1;
        int curr = 0;
        while (r >= 0 && curr < s.length()) {
            if (s.charAt(r) == s.charAt(curr)) {
                r--;
                curr++;
            } else {
                if (curr > 0) {
                    int zheng = next[curr - 1];
                    curr = zheng;
                } else {
                    r--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(curr));
        sb.reverse();
        sb.append(s);
        return sb.toString();
    }

    //骚操作 KMP变种
    //https://leetcode.cn/problems/shortest-palindrome/solution/shou-hua-tu-jie-cong-jian-dan-de-bao-li-fa-xiang-d/
    public String shortestPalindrome3(String s) {
        if (s.length() < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String rev = sb.toString();
        sb = new StringBuilder();
        sb.append(s);
        sb.append("#");
        sb.append(rev);
        String keySt = sb.toString();
        //next数组
        int[] next = new int[keySt.length()];
        next[0] = 0;
        int i = 1;
        int now = 0;
        while ( i < keySt.length() ) {
            if (keySt.charAt(i) == keySt.charAt(now)) {
                now++;
                next[i] = now;
                i++;
            } else if (now != 0) {
                now = next[now - 1];
            } else {
                next[i] = now;
                i++;
            }
        }
        int k = next[keySt.length() - 1];
        if (k == s.length()) {
            return s;
        }
        String kst = s.substring(k);
        sb = new StringBuilder();
        sb.append(kst);
        sb.reverse();
        sb.append(s);
        return sb.toString();
    }

    //答案 字符串Hash算法
    public String shortestPalindrome4(String s) {
        int n = s.length();
        int base = 131, mod = 1000000007;
        int left = 0, right = 0, mul = 1;
        int best = -1;
        for (int i = 0; i < n; ++i ) {
            left = (int) (((long) left * base + s.charAt(i)) % mod);
            right = (int) ((right + (long) mul * s.charAt(i)) % mod);
            if (left == right) {
                best = i;
            }
            mul = (int) ((long) mul * base % mod);
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();

    }

    public static void main(String[] args) {
        String test = "aacecaaa";
        E214_ShortestPalindrome temp = new E214_ShortestPalindrome();
        String res = temp.shortestPalindrome3(test);
        System.out.println(res);
    }

}
