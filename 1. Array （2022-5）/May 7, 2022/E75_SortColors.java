public class E75_SortColors {
    // l, r pointer, 2-r, 0-l
    public void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }


        int r = 0;
        int one = 0;
        outer1:
        for (int i = 0; i < nums.length; i++) {
            while (i <= nums.length - r - 1 && nums[i] == 2) {
                nums[i] = nums[nums.length - 1 - r];
                nums[nums.length - 1 - r] = 2;
                r++;
            }

            if (one == 0 && nums[i] != 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 0) {
                        nums[j] = nums[i];
                        nums[i] = 0;
                        continue outer1;
                    }
                }
                one = 1;
                continue outer1;
            }
        }




    }
}
