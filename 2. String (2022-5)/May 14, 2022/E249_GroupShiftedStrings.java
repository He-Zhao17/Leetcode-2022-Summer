import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E249_GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        if (strings.length == 0) {
            return res;
        }
        for (String str: strings) {
            StringBuilder sb = new StringBuilder();
            char[] arr = str.toCharArray();
            char pow = arr[0];
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] >= pow) {
                    sb.append((int) arr[i] - pow);
                    //！！！！！！！！必须空格 不然1 2 和12 一样
                    sb.append(" ");
                } else {
                    sb.append(((int) arr[i] + 26 - pow));
                    sb.append(" ");
                }

            }
            String key = sb.toString();
            List<String> list =  map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        E249_GroupShiftedStrings temp = new E249_GroupShiftedStrings();
        String[] nums = {
                "abc","am"
        };
        temp.groupStrings(nums);
    }

}
