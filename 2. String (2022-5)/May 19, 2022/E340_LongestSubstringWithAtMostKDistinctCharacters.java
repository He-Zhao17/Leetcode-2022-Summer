import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class E340_LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() <= k) {
            return s.length();
        }
        if (k == 0) {
            return 0;
        }


        int l = 0;
        int r = 1;
        char[] arr = s.toCharArray();
        int dup = k;
        Map<Character, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        int max = 1;
        dup--;
        boolean yn = false;

        while (l <= r && r < arr.length) {
            if (!map.containsKey(arr[r])) {
                if (dup == 0) {
                    Map.Entry<Character, Integer> minEntry = null;
                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                        if (minEntry == null) {
                            minEntry = entry;
                        }
                        if (minEntry.getValue() > entry.getValue()) {
                            minEntry = entry;
                        }
                    }
                    l = minEntry.getValue() + 1;
                    map.remove(minEntry.getKey());
                    map.put(arr[r], r);
                    if (dup == 0) {
                        if (max < r - l + 1) {
                            max = r - l + 1;
                        }
                    }
                    dup++;
                }
                dup--;
                map.put(arr[r], r);
                if (dup == 0) {
                    if (max < r - l + 1) {
                        max = r - l + 1;
                    }
                }
                r++;
            } else {
                map.put(arr[r], r);
                if (max < r - l + 1) {
                    max = r - l + 1;
                }
                r++;
            }
        }
        return max < r - l ? r - l : max;

    }

    public static void main(String[] args) {
        String test =  "eceba";
        E340_LongestSubstringWithAtMostKDistinctCharacters temp = new E340_LongestSubstringWithAtMostKDistinctCharacters();
        int res = temp.lengthOfLongestSubstringKDistinct(test, 2);

    }
}
