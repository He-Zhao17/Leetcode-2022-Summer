import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class E298_BinaryTreeLongestConsecutiveSequece {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int max = 1;
        while (!que.isEmpty()) {
            TreeNode curr = que.poll();
            int currLen = map.get(curr);
            if (curr.left != null) {
                if (curr.left.val == curr.val + 1) {
                    map.put(curr.left, currLen + 1);
                    if (max < currLen + 1) {
                        max = currLen + 1;
                    }
                } else {
                    map.put(curr.left, 1);
                }
                que.offer(curr.left);
            }
            if (curr.right != null) {
                if (curr.right.val == curr.val + 1) {
                    map.put(curr.right, currLen + 1);
                    if (max < currLen + 1) {
                        max = currLen + 1;
                    }
                } else {
                    map.put(curr.right, 1);
                }
                que.offer(curr.right);
            }
        }
        return max;


    }
}
