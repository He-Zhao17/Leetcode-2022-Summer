public class E35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int m = nums[mid];
            if (m == target) {
                return mid;
            } else if (m > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] == target) {
            return l;
        } else if (nums[l] < target) {
            return l + 1;
        } else {
            return l;
        }

    }
}
