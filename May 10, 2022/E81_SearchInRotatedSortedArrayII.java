public class E81_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {

        //二分不如不二分
        /*int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[l]) {

            }


        }
*/

        for (int i = 0; i < nums.length; ++i) {
            if(nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}
