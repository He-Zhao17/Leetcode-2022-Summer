public class E34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int l = 0;
        int r = nums.length - 1;

        //更优秀的 解法是直接找第一个 然后往后遍历 不过大差不差

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                l = mid;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[l] == target) {
            int indexl = l;
            while (indexl >= 0) {
                if (nums[indexl] == target) {
                    indexl--;
                } else {
                    indexl++;
                    break;
                }
            }
            indexl = indexl < 0 ? 0 : indexl;
            int indexr = l;
            while (indexr < nums.length) {
                if (nums[indexr] == target) {
                    indexr++;
                } else {
                    indexr--;
                    break;
                }
            }
            indexr = indexr > nums.length - 1 ? nums.length - 1 : indexr;
            int[] res = {indexl, indexr};
            return res;
        } else {
            return new int[]{-1, -1};
        }

    }

}
