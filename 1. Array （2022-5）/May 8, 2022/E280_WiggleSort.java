public class E280_WiggleSort {
    //先排序 再颠倒
    public void wiggleSort(int[] nums) {
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length - j; ++i) {
                if (i == nums.length - 1) {
                    continue;
                }
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        for (int i = 1; i < nums.length; i = i + 2) {
            if (i + 1 < nums.length) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }
    //...直觉告诉我可以一遍，于是我看了答案
    //其实很简单= =我想多了 多动笔
    public void wiggleSort2 (int[] nums) {
        boolean less = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
            less = !less;
        }
    }


}
