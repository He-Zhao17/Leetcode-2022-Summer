public class E198_HouseRobber {
    public int rob(int[] nums) {
        int[] withOut = new int[nums.length];
        int[] withIn = new int[nums.length];
        withIn[0] = nums[0];
        withOut[0] = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            withIn[i] = nums[i] + withOut[i - 1];
            withOut[i] = Math.max(withIn[i - 1], withOut[i - 1]);
            if (withIn[i] > max) {
                max = withIn[i];
            }
            if (withOut[i] > max) {
                max = withOut[i];
            }
        }
        return max;

    }

}
