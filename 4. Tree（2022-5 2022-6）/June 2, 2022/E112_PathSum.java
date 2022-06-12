import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-06-02 10:52
 */


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
public class E112_PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        queueNode.offer(root);
        Queue<Integer> queueRes = new LinkedList<>();
        queueRes.offer(root.val);

        while (!queueNode.isEmpty()) {
            TreeNode curr = queueNode.poll();
            int num = queueRes.poll();

            if (curr.left == null && curr.right == null) {
                if (num == targetSum) {
                    return true;
                }
            } else {
                if (curr.left != null) {
                    queueNode.offer(curr.left);
                    queueRes.offer(num + curr.left.val);
                }
                if (curr.right != null) {
                    queueNode.offer(curr.right);
                    queueRes.offer(num + curr.right.val);
                }
            }
        }
        return false;
    }

}

























