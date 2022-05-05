/**
 * <p>Remove Element</p>
 * <p>Array-Easy-Leetcode 27</p>
 *
 * @author: He Zhao
 * @create: 2022-05-04 19:59
 */
public class E27_RemoveElement {
    //double pointer
    public int removeElement2 (int[] nums, int val) {
        if (nums.length == 0 ){
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }

    //mine-better
    public int removeElement (int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i != j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                nums[j] = val;
                j--;
            } else {
                i++;
            }
        }
        if (nums[j] == val) {
            return j;
        } else {
            return j + 1;
        }
    }
}
