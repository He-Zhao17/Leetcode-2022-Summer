public class E154_FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;


    }

    //花里胡哨其实没啥卵用的二分法
    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }


}
