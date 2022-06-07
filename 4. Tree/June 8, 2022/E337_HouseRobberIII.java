import com.sun.source.tree.Tree;

import java.util.HashMap;

public class E337_HouseRobberIII {
    HashMap<TreeNode, Integer> no = new HashMap<>();
    HashMap<TreeNode, Integer> with = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null ){
            return 0;
        }
        int w = getWithRoot(root);
        int n = getNoRoot(root);
        return Math.max(w, n);
    }
    private int getNoRoot (TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (no.containsKey(root)) {
            return no.get(root);
        }
        int left, leftno, right, rightno;
        if (root.left != null && with.containsKey(root.left)) {
            left = with.get(root.left);
        } else {
            left = getWithRoot(root.left);
            with.put(root.left, left);
        }
        if (root.left != null && no.containsKey(root.left)) {
            leftno = no.get(root.left);
        } else {
            leftno = getNoRoot(root.left);
            no.put(root.left, leftno);
        }
        if (root.right != null && with.containsKey(root.right)) {
            right = with.get(root.right);
        } else {
            right = getWithRoot(root.right);
            with.put(root.right, right);
        }
        if (root.right != null && no.containsKey(root.right)) {
            rightno = no.get(root.right);
            no.put(root.right, rightno);
        } else {
            rightno = getNoRoot(root.right);
            no.put(root.right, rightno);
        }
        int ans = Math.max(left, leftno) + Math.max(right, rightno);
        no.put(root, ans);
        return ans;

    }
    private int getWithRoot (TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (with.containsKey(root)) {
            return with.get(root);
        }
        int leftno, rightno;
        if (root.left != null && no.containsKey(root.left)) {
            leftno = no.get(root.left);
        } else {
            leftno = getNoRoot(root.left);
            no.put(root.left, leftno);
        }
        if (root.right != null && no.containsKey(root.right)) {
            rightno = no.get(root.right);
            no.put(root.right, rightno);
        } else {
            rightno = getNoRoot(root.right);
            no.put(root.right, rightno);
        }
        int ans = root.val + leftno + rightno;
        with.put(root, ans);
        return ans;
    }
}
