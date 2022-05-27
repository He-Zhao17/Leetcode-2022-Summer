import java.util.*;

public class E18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res  = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 3; i++) {
            //注意负数的target
            /*if (nums[i] > target && nums[i] > 0) {
                continue;
            }*/

            //优化后的
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                continue;
            }
            if ((long)nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3]  < target) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; ++j ){
                if (map.containsKey(nums[i]) && map.get(nums[i]).contains(nums[j])) {
                    continue;
                }
                Set<Integer> set = map.containsKey(nums[i]) ? map.get(nums[i]) : new HashSet<Integer>();
                //优化后
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2]  > target) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target){
                    continue;
                }
                set.add(nums[j]);
                map.put(nums[i], set);
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int temp = nums[i] + nums[j] + nums[l] + nums[r];
                    if (temp == target) {
                        ArrayList<Integer> temp1 = new ArrayList<>();
                        temp1.add(nums[i]);
                        temp1.add(nums[j]);
                        temp1.add(nums[l]);
                        temp1.add(nums[r]);
                        res.add(temp1);
                        l++;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        r--;
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    } else if (temp < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        E18_FourSum temp = new E18_FourSum();
        List<List<Integer>> res = temp.fourSum(nums, -11);
        System.out.println(res);
    }
}
