import javax.sound.sampled.Line;

public class E162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int l = 0;
        int r = len - 1;

        while ( l < r) {
            int mid = l + (r - l) /2;
            int m = nums[mid];
            int b = mid - 1 >= 0 ? nums[mid - 1] : Integer.MIN_VALUE;
            int f = mid + 1 >= len ? Integer.MIN_VALUE : nums[mid + 1];
            if (b < m && f < m) {
                return mid;
            } else {
                if (f > m) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return l;
    }

    public static void main(String[] args) {
        E162_FindPeakElement temp = new E162_FindPeakElement();
        temp.findPeakElement(new int[] {6,5,4,3,2,3,2});
    }
}
