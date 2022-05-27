import java.util.*;

public class E15_ThreeSum {
    //我的答案 一次Hashmap优化 超时
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        HashMap<Integer, Set<int[]>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                Set<int[]> temp = map.containsKey(nums[i] + nums[j]) ? map.get(nums[i] + nums[j]) : new HashSet<int[]>();
                int[] temparr = new int[4];
                temparr[0] = nums[i] < nums[j] ? i : (nums[i] == nums[j] ? i : j);
                temparr[1] = nums[i] < nums[j] ? j : (nums[i] == nums[j] ? j : i);
                temparr[2] = nums[i] < nums[j] ? nums[i] : (nums[i] == nums[j] ? nums[i] : nums[j]);
                temparr[3] = nums[i] < nums[j] ? nums[j] : (nums[i] == nums[j] ? nums[j] : nums[i]);
                if (!temp.contains(temparr)) {
                    temp.add(temparr);
                }
                map.put(nums[i] + nums[j], temp);
            }
        }
        Set<ArrayList<Integer>> set1 = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(0 - nums[i])) {
                Set<int[]> temp = map.get(0 - nums[i]);
                for (int[] arr : temp) {
                    if (i != arr[0] && i != arr[1]) {
                        ArrayList<Integer> temp1 = new ArrayList<>();
                        temp1.add(nums[i] < arr[2] ? nums[i] : arr[2]);
                        temp1.add(nums[i] < arr[2] ? arr[2] : (nums[i] > arr[3] ? arr[3] : (nums[i] == arr[3] ? arr[3] : nums[i])));
                        temp1.add(nums[i] > arr[3] ? nums[i] : (nums[i] == arr[3] ? nums[i] : arr[3]));
                        set1.add(temp1);
                    }
                }
            }
        }
        res.addAll(set1);
        return res;
    }

    //答案 去重的操作很秀
    //https://leetcode.cn/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            if (nums[i] > 0) {
                break;
            }
            if ( i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        E15_ThreeSum temp = new E15_ThreeSum();
        int[] nums = {-1,0,1,0};
        List<List<Integer>> res = temp.threeSum(nums);
        System.out.println(res);
    }
}
