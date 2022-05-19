import java.util.HashMap;
import java.util.Map;

public class E3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 1;
        char[] arr = s.toCharArray();
        int max = 1;
        map.put(arr[0], 0);
        while (l <= r && r < s.length()) {
            if (!map.containsKey(arr[r]) || (map.containsKey(arr[r]) && map.get(arr[r]) < l)) {
                if (max < r - l + 1) {
                    max = r - l + 1;
                }
                map.put(arr[r], r);
                r++;
            } else {
                l = map.get(arr[r]) + 1;
                map.put(arr[r], r);
                r++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String test = "abcabcbb";
        E3_LongestSubstringWithoutRepeatingCharacters temp = new E3_LongestSubstringWithoutRepeatingCharacters();
        int res = temp.lengthOfLongestSubstring(test);
        System.out.println(test);
    }

}
