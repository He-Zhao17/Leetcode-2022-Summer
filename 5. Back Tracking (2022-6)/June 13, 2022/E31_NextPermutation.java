import java.util.Arrays;

public class E31_NextPermutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i] > nums[i - 1]) {
                int min = nums[i];
                int minIndex = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1] && nums[j] < min) {
                        minIndex = j;
                        min = nums[j];
                    }
                }
                int k = nums[i - 1];
                nums[i - 1] = nums[minIndex];
                nums[minIndex] = k;
                int[] arr = new int[nums.length - i];
                System.arraycopy(nums, i, arr, 0, arr.length);
                Arrays.sort(arr);
                System.arraycopy(arr, 0, nums, i, arr.length);
                return;
            }
        }
        Arrays.sort(nums);
    }
}
