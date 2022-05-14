import org.w3c.dom.ls.LSException;

import java.lang.reflect.Array;
import java.util.*;

public class E49_GroupAnagrams {

    //我的方法 - 双指针（算吧—--）
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            List<List<String>> temp = new ArrayList<>();
            return temp;
        }

        ArrayList<int[]> mapArr = new ArrayList<>();
        int[] temp = new int[27];
        Arrays.fill(temp, 0);
        temp[0] = strs[0].length();

        for (int i = 0; i < strs[0].length(); ++i) {
            int numindex = (int) strs[0].charAt(i) - 96;
            temp[numindex]++;
        }
        mapArr.add(temp);
        List<List<String>> res = new ArrayList<>();
        List<String> temp1 = new ArrayList<>();
        temp1.add(strs[0]);
        res.add(temp1);

        outer1:
        for (int i = 1; i < strs.length; ++i) {
            outer2:
            for (int j = 0; j < mapArr.size(); ++j) {
                if (mapArr.get(j)[0] == strs[i].length()) {
                    //此处可以将新的也hash一遍对比， 占用少一点
                    int[] check = new int[27];
                    for (int q = 0; q < 27; ++q) {
                        check[q] = mapArr.get(j)[q];
                    }
                    for (int q = 0; q < strs[i].length(); ++q) {
                        int numIndex = (int) strs[i].charAt(q) - 96;
                        if (check[numIndex] > 0) {
                            check[numIndex]--;
                        } else {
                            continue outer2;
                        }
                    }
                    res.get(j).add(strs[i]);
                    continue outer1;
                }
            }
            //创建
            int[] temp2 = new int[27];
            Arrays.fill(temp2, 0);
            temp2[0] = strs[i].length();

            for (int k = 0; k < strs[i].length(); ++k) {
                int numindex = (int) strs[i].charAt(k) - 96;
                temp2[numindex]++;
            }
            mapArr.add(temp2);
            List<String> temp3 = new ArrayList<>();
            temp3.add(strs[i]);
            res.add(temp3);
        }
        return res;

    }

    //答案1： 排序
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    //答案3： 我的改进版 使用了Hash表进行保存res
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            //！！！精彩 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }





    public static void main(String[] args) {
        E49_GroupAnagrams temp = new E49_GroupAnagrams();
        String[] nums = {"eat","tea","tan","ate","nat","bat"};
        temp.groupAnagrams(nums);
    }


}
