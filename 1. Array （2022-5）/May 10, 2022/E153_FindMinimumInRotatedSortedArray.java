public class E153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int pivot = -1;

        outer1:
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (r <= l + 3) {
                for (int i = l; i < r; ++i) {
                    if (nums[i + 1] < nums[i]) {
                        pivot = i + 1;
                        break outer1;
                    }
                }
                break outer1;
            }
            //normal
            if (nums[mid - 1] < nums[mid + 1]) {
                if (nums[mid - 1] > nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid -1;
                }
            } else {

                //  4, 5, 1, 2, 3 必须mid - 1 不能mid  否则nums[mid] = 1 就会以为没rotated
                l = mid - 1;
            }
        }

        if (pivot == -1) {
            return nums[0];
        } else {
            return nums[pivot];
        }

    }

    // 答案 简洁版
    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }




}
