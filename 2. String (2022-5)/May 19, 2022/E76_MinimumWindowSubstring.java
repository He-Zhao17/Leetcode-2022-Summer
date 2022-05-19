import java.util.*;

public class E76_MinimumWindowSubstring {
    //我的解法 占用内存稍微有点大 不过思想是一样的 都是滑动窗口
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;
        char[] arr = t.toCharArray();
        int min = Integer.MAX_VALUE;
        int resl = -1;
        int resr = -1;
        Set<Character> set = new HashSet<>();
        Set<Integer> indexs = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            set.add(arr[i]);
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        while (l <= r && r < s.length()) {
            if (l == r) {
                char ch = s.charAt(l);
                if (indexs.contains(l)) {
                    r++;
                } else {
                    if (set.contains(ch)) {
                        indexs.add(l);
                        if (map.get(ch) == 1) {
                            map.put(ch, 0);
                            set.remove(ch);
                            if (set.size() > 0) {
                                r++;
                            }
                        } else {
                            map.put(ch, map.get(ch) - 1);
                            r++;
                        }

                    } else {
                        l++;
                        r++;
                    }
                }

            } else {
                if (set.size() > 0 ){
                    char ch = s.charAt(r);
                    if (map.containsKey(ch)) {
                        if (set.contains(ch)) {
                            indexs.add(r);
                        }
                        if (map.get(ch) == 1) {
                            map.put(ch, 0);
                            set.remove(ch);
                            if (set.size() > 0) {
                                r++;
                            }
                        } else if (map.get(ch) <= 0) {
                            map.put(ch, map.get(ch) - 1);
                            r++;
                        }
                        else {
                            map.put(ch, map.get(ch) - 1);
                            r++;
                        }
                    } else {
                        r++;
                    }
                } else {
                    while (set.size() == 0) {
                        if (r - l + 1 < min) {
                            resl = l;
                            resr = r;
                            min = r - l + 1;
                        }
                        char ch = s.charAt(l);
                        if (map.containsKey(ch)) {
                            indexs.remove(l);
                            map.put(ch, map.get(ch) + 1);
                            if (map.get(ch) > 0) {
                                set.add(ch);
                            }
                        }
                        l++;
                    }
                    r++;
                }
            }

        }
        String res;
        if (resl == -1) {
            return "";
        } else {
            if (r == s.length() - 1) {
                res = s.substring(resl);
            } else {
                res = s.substring(resl, resr + 1);
            }
            return res;
        }

    }

    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        E76_MinimumWindowSubstring temp = new E76_MinimumWindowSubstring();
        String res = temp.minWindow(s, t);
        System.out.println(res);
    }

}
