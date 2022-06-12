import java.util.Stack;

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
class BSTIterator {
    TreeNode pointer = null;
    Stack<TreeNode> sta = new Stack<>();
    public BSTIterator(TreeNode root) {
        if (root == null) {
            pointer = null;
        }
        TreeNode curr = root;
        while (curr != null) {
            sta.push(curr);
            curr = curr.left;
        }
    }

    public int next() {
        TreeNode curr = sta.pop();
        int ans = curr.val;
        curr = curr.right;
        while (curr != null) {
            sta.push(curr);
            curr = curr.left;
        }
        return ans;
    }

    public boolean hasNext() {
        return !sta.isEmpty();
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */