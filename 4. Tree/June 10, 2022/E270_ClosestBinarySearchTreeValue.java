
public class E270_ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        TreeNode curr = root;
        int up = Integer.MAX_VALUE;
        int down = Integer.MIN_VALUE;
        while (curr != null) {
            if ((double)curr.val < target) {
                down = curr.val;
                curr = curr.right;
            } else if ((double) curr.val > target) {
                up = curr.val;
                curr = curr.left;
            } else {
                return curr.val;
            }
        }
        return (double) up - target > target - (double) down ? down : up;

    }

}
