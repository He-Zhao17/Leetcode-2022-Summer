public class E33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len = nums.length - 1;
        int l = 0;
        int r = len;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int m = nums[mid];
            if (nums[l] < nums[r]) {
                if (m == target) {
                    return mid;
                } else if (m < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                if (m < target) {
                    if (m >= nums[r]) {
                        l = mid + 1;
                    } else {
                        if (target > nums[r]) {
                            r = mid;
                        } else {
                            l = mid + 1;
                        }
                    }

                } else {
                    if (m >= nums[l]) {
                        if (target < nums[l]) {
                            l = mid + 1;
                        } else {
                            r = mid;
                        }
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

    public static void main(String[] args) {
        E33_SearchInRotatedSortedArray temp = new E33_SearchInRotatedSortedArray();
        int k = temp.search(new int[]{3, 1}, 1);
    }


}
