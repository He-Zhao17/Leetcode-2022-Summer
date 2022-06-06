import javax.swing.tree.TreePath;
import java.util.LinkedList;
import java.util.Queue;

public class E110_BalancedBinaryTree {


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return false;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return false;
        }
        if (Math.abs(left - right) > 1) {
            return false;
        } else {
            return true;
        }

    }
    private int getDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    //DFS+QUEUE 不行
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int min = 0;
        int depth = 1;
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; ++i) {
                TreeNode curr = que.poll();
                if (curr.left != null && curr.right != null) {
                    que.offer(curr.left);
                    que.offer(curr.right);
                } else {
                    if (min == 0) {
                        min = depth;
                    } else {
                        if (depth - min > 1) {
                            return false;
                        }
                    }
                    if (curr.left != null) {
                        que.offer(curr.left);
                    }
                    if (curr.right != null) {
                        que.offer(curr.right);
                    }
                }
            }
            depth++;
        }
        return true;
    }

}
