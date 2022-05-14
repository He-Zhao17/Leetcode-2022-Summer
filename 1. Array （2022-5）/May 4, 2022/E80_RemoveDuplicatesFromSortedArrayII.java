/**
 * <p>Remove Duplcates from Sorted Array II</p>
 * <p>Array-normal-E80</p>
 *
 * @author: He Zhao
 * @create: 2022-05-04 21:46
 */
public class E80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates (int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 1;
        int fast = 1;
        int cat = 1;

        while (fast < nums.length) {
            if (nums[fast] == nums[fast - 1]) {
                if (cat == 1) {
                    cat++;
                    nums[slow] = nums[fast];
                    slow++;
                }
            } else {
                nums[slow] = nums[fast];
                cat = 1;
                slow++;
            }
            fast++;
        }
        return slow;
    }


    // better
    public int RemoveDuplicatesFromSortedArrayII2(int[] nums) {
        if (nums.length <= 2) {
            return 2;
        }
        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!这里是slow-2 不是fast-2！！！！！！！
            if (nums[fast] > nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

    public static void main(String[] args) {
        E80_RemoveDuplicatesFromSortedArrayII temp = new E80_RemoveDuplicatesFromSortedArrayII();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int k = temp.removeDuplicates(nums);
        System.out.println("sss");
    }
}
