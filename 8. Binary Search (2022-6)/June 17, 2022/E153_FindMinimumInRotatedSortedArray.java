public class E153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int min = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int m = nums[mid];
            if (nums[l] < nums[r]) {
                return nums[l];
            } else {
                if (m > nums[l]) {
                    l = mid + 1;
                } else if (m == nums[l]) {
                    return nums[r];
                } else {
                    r = mid;
                }
            }
        }
        return nums[l];
    }

}
