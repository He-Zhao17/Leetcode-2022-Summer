public class E08_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid != 0) {
            int[] left = new int[mid];
            for (int i = 0; i < mid; i++) {
                left[i] = nums[i];
            }
            root.left = sortedArrayToBST(left);
        }
        if (mid != nums.length - 1) {
            int[] right = new int[nums.length - mid - 1];
            for (int i = mid + 1; i < nums.length; i++) {
                right[i - mid - 1] = nums[i];
            }
            root.right = sortedArrayToBST(right);
        }
        return root;


    }
}
