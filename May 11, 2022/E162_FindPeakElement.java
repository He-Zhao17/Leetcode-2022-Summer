public class E162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums[1] < nums[0]) {
            return 0;
        }
        if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums.length - 1;
        }

        int l = 0;
        int r = nums.length - 1;

        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i + 1] > nums[i]) {
                if (nums[i + 2] < nums[i + 1]) {
                    return i + 1;
                } else if (nums[i + 2] == nums[i + 1]){
                    i += 2;
                } else {
                    i++;
                }
            } else if (nums[i + 1] == nums[i]) {
                i++;
            } else {
                i++;
            }
        }
        return -1;
    }

    //贪心二分 如果上升则必有peak
    public int findPeakElement2 (int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while ( l < r ) {
            int mid = l + (r - l) / 2;
            //nums[mid] < nums[mid+1] ? (l = mid + 1) : (r = mid);
        }
        return l ;

    }
}
