import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
public class E235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while ((p.val - curr.val) * (q.val - curr.val) > 0) {
            if (p.val == curr.val || q.val == curr.val) {
                return curr;
            }
            if (p.val > curr.val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return curr;
    }
}
