public class E213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return  nums[0];
        }
        int[] withOut = new int[nums.length];
        int[] withIn = new int[nums.length];

        // if 0- in
        withIn[1] = nums[0];
        withOut[1] = nums[0];
        int max = nums[0];
        for (int i = 2; i < nums.length - 1; i++) {
            withIn[i] = nums[i] + withOut[i - 1];
            withOut[i] = Math.max(withIn[i - 1], withOut[i - 1]);
            int m = Math.max(withIn[i] , withOut[i]);
            max = max > m ? max : m;
        }
        // if 0 out
        withIn = new int[nums.length];
        withOut = new int[nums.length];
        withIn[1] = nums[1];
        withOut[1] = 0;
        if (nums[1] > max) {
            max = nums[1];
        }
        for (int i = 2; i < nums.length; i++) {
            withIn[i] = nums[i] + withOut[i - 1];
            withOut[i] = Math.max(withIn[i - 1], withOut[i - 1]);
            int m = Math.max(withIn[i] , withOut[i]);
            max = max > m ? max : m;
        }
        return max;
    }

    public static void main(String[] args) {
        E213_HouseRobberII temp = new E213_HouseRobberII();
        int res = temp.rob(new int[]{200, 3, 140, 20, 10});
    }
}
