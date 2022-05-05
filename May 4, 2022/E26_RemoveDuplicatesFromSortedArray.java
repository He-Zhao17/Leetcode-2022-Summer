/**
 * <p>Remove Duplicates from Sorted Array</p>
 * <p>Array-easy-E26</p>
 *
 * @author: He Zhao
 * @create: 2022-05-04 20:35
 */
public class E26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] > nums[left]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;

    }

    // better
    public int removeDuplicates2 (int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] > nums[fast -1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        E26_RemoveDuplicatesFromSortedArray temp = new E26_RemoveDuplicatesFromSortedArray();
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int k = temp.removeDuplicates(arr);
        System.out.println("kkk");
    }
}
