class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class E124_BinaryTreeMaximumPathSum {
    int maxInner = 0;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return  0;
        }

        maxInner = root.val;
        int maxk = maxNode(root);
        return Math.max(maxk, maxInner);
    }
    private int maxNode(TreeNode root) {
        if (root == null ){
            return 0;
        }
        if (root.val > maxInner) {
            maxInner = root.val;
        }
        int left = maxNode(root.left);
        int right = maxNode(root.right);
        int maxp = Math.max(left + right + root.val, Math.max(left + root.val, right + root.val));
        maxInner = maxInner < maxp ? maxp : maxInner;
        return Math.max(root.val, Math.max (left + root.val, right + root.val));
    }




}
