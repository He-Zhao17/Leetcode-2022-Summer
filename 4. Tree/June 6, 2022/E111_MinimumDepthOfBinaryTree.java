import com.sun.source.tree.Tree;

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
public class E111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int depth = 1;
        while (true) {
            int len = que.size();
            for (int i = 0; i < len; ++i) {
                TreeNode curr = que.poll();
                if (curr.left != null || curr.right != null) {
                    if (curr.left != null) {
                        que.offer(curr.left);
                    }
                    if (curr.right != null) {
                        que.offer(curr.right);
                    }
                } else {
                    return depth;
                }
            }
            depth++;
        }
    }
}
