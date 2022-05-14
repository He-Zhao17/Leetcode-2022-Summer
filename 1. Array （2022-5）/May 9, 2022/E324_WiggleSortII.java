public class E324_WiggleSortII {
    public void wiggleSort(int[] nums) {
        //0 <= nums[i] <= 5000
        int[] bucket = new int[5001];

        for (int i = 0; i < nums.length; ++i) {
            bucket[nums[i]]++;
        }

        int big = 0;
        int small = 0;
        if (nums.length % 2 == 0) {
            big = nums.length - 1;
            small = nums.length - 2;
        } else {
            big = nums.length - 2;
            small = nums.length - 1;
        }
        int j = bucket.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
        for (int i = 0; i < nums.length; i += 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }


    }

}
