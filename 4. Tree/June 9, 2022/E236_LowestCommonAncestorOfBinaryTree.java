import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class E236_LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        map.put(root, null);
        boolean pF = false;
        boolean qF = false;
        while (!que.isEmpty() && (!pF || !qF)) {
            TreeNode curr = que.poll();
            if (curr.val == p.val) {
                pF = true;
            }
            if (curr.val == q.val) {
                qF = true;
            }
            if (curr.left != null) {
                map.put(curr.left, curr);
                que.offer(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                que.offer(curr.right);
            }
        }
        TreeNode pt = p;
        while (pt != null) {
            TreeNode qt = q;
            while (qt != null) {
                if (pt.val == qt.val) {
                    return pt;
                }
                qt = map.get(qt);
            }
            pt = map.get(pt);
        }
        return root;
    }
}
