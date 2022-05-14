import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class E350_IntersectionOfTwoArrayII {
    //我的方法： 排序 + 双指针
    public int[] intersect(int[] nums1, int[] nums2) {
        sort(nums1);
        sort(nums2);
        int i1 = 0;
        int i2 = 0;
        ArrayList<Integer> resArrL = new ArrayList<>();
        while (i1 < nums1.length && i2 < nums2.length) {
            while (nums1[i1] < nums2[i2]) {
                i1++;
                if (i1 > nums1.length - 1) {
                    int[] res = new int[resArrL.size()];
                    for (int i = 0; i < resArrL.size(); ++i) {
                        res[i] = resArrL.get(i);
                    }
                    return res;
                }

            }
            while (nums2[i2] < nums1[i1]) {
                i2++;
                if (i2 > nums2.length - 1) {
                    int[] res = new int[resArrL.size()];
                    for (int i = 0; i < resArrL.size(); ++i) {
                        res[i] = resArrL.get(i);
                    }
                    return res;
                }

            }
            if (nums1[i1] == nums2[i2]) {
                resArrL.add(nums1[i1]);
                i1++;
                i2++;
            }

        }
        int[] res = new int[resArrL.size()];
        for (int i = 0; i < resArrL.size(); ++i) {
            res[i] = resArrL.get(i);
        }
        return res;
    }


    //方法2 ： from 答案 hashmap
    public int[] intersect2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> resArrL = new ArrayList<>();
        for (int i = 0; i < nums1.length; ++i) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; ++i) {
            if (map.containsKey(nums2[i]) &&
             map.get(nums2[i]) > 0) {
                resArrL.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[resArrL.size()];
        for (int i = 0; i < resArrL.size(); ++i) {
            res[i] = resArrL.get(i);
        }
        return res;
    }

    private void swap (int[] nums,int l ,int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private void sort(int[] nums) {

        for (int j = nums.length - 1; j > 0; j--) {
            for (int i = 0; i < j; ++i) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        E350_IntersectionOfTwoArrayII temp = new E350_IntersectionOfTwoArrayII();
        int[] nums1 = {7,2,2,4,7,0,3,4,5};
        int[] nums2 = {3,9,8,6,1,9};
        temp.intersect(nums1, nums2);

    }

}
