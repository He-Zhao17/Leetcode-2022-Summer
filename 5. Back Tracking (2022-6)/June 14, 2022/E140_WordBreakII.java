import java.util.*;

public class E140_WordBreakII {
    Set<String> set = new HashSet<>();
    int[] longest = new int[26];
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Arrays.fill(longest, 0);
        for (String str: wordDict) {
            int len = str.length();
            if (len > longest[str.charAt(0) - 'a']) {
                longest[str.charAt(0) - 'a'] = len;
            }
            set.add(str);
        }
        help(s, 0);
        return ans;
    }
    private void help (String s, int index ) {
        char ch = s.charAt(index);
        int len = 0;
        StringBuilder sp = new StringBuilder();
        for (int i = index; i < s.length(); ++i) {
            sp.append(s.charAt(i));
            len++;
            if (len > longest[ch - 'a']) {
                return;
            }
            if (set.contains(sp.toString())) {
                int len1 = 0;
                if (sb.length() != 0) {
                    len1++;
                    sb.append(" ");
                }
                len1 += sp.length();
                sb.append(sp.toString());
                if (index + sp.length() == s.length()) {
                    ans.add(sb.toString());
                } else {
                    help(s, index + sp.length());
                }
                sb.delete(sb.length() - len1, sb.length());
            }
        }
    }

    public static void main(String[] args) {
        String[] dic = {"cat","cats","and","sand","dog"};
        List<String> dict = new ArrayList<>();
        for (String str : dic) {
            dict.add(str);
        }
        String s = "catsanddog";
        E140_WordBreakII temp = new E140_WordBreakII();
        List<String> ans = temp.wordBreak(s, dict);

    }
}
