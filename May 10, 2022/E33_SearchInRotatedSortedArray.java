public class E33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[l]) {
                if (target == nums[mid]) {
                    return mid;
                } else if (target < nums[mid]) {
                    r = mid;
                } else {
                    if (target > nums[r]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
            } else {
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    l = mid + 1;
                } else {
                    if (target < nums[l]) {
                        l = mid +  1;
                    } else {
                        r = mid;
                    }
                }
            }
        }
        if (nums[l] == target) {
            return l;
        } else {
            return -1;
        }

    }
}
