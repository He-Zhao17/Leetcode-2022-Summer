public class E238_ProductOfArrayExceptSelf {
    //上下三角 https://leetcode-cn.com/problems/product-of-array-except-self/solution/product-of-array-except-self-shang-san-jiao-xia-sa/
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int up = 1;
        int down = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = down;
            down *= nums[i];
        }

        for (int i = nums.length - 1; i > -1; i--) {
            res[i] *= up;
            up *= nums[i];
        }
        return res;
    }
}
