public class E154_FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int m = nums[mid];

            if (nums[l] == nums[r]) {
                if (nums[l] == m) {
                    if (r - l + 1 == 2) {
                        return nums[l];
                    }
                    l++;
                    r--;
                } else {
                    if (m > nums[l]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
            } else if (nums[l] > nums[r]) {
                if (m == nums[l]) {
                    l = mid + 1;
                } else if (m < nums[l]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                return nums[l];
            }
        }
        return nums[l];

    }

    public static void main(String[] args) {
        E154_FindMinimumInRotatedSortedArrayII temp = new E154_FindMinimumInRotatedSortedArrayII();
        temp.findMin(new int[] {1, 1});
    }
}
