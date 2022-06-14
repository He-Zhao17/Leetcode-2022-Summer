import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class E291_WordPatternII {
    HashMap<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    public boolean wordPatternMatch(String pattern, String s) {
        if (s.length() < pattern.length()) {
            return false;
        }
        return help(pattern, s, 0, 0);
    }
    private boolean help (String pattern, String s, int a, int b) {
        for (int i = a; i < pattern.length(); i++) {
            char ac = pattern.charAt(i);
            if (map.containsKey(ac)) {
                String temp = map.get(ac);
                if (b + temp.length() > s.length()) {
                    return false;
                }
                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) != s.charAt(b + j)) {
                        return false;
                    }
                }
                if (b + temp.length() == s.length()) {
                    return true;
                }
                b = b + temp.length();
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                for (int j = b; j < s.length() - (pattern.length() - i - 1); j++) {
                    sb.append(s.charAt(j));
                    if (set.contains(sb.toString())) {
                        continue;
                    } else {
                        map.put(ac, sb.toString());
                        set.add(sb.toString());
                    }

                    if (help(pattern, s, 0, 0)) {
                        return true;
                    } else {
                        map.remove(ac);
                        set.remove(sb.toString());
                    }
                }
                return false;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        String pattern = "ab";
        String s = "aa";
        E291_WordPatternII temp = new E291_WordPatternII();
        temp.wordPatternMatch(pattern, s);
    }

}
