import com.sun.source.tree.Tree;

import java.awt.image.CropImageFilter;
import java.util.Stack;

//Definition for a binary tree node.
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
public class E101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        //中序遍历是没用的[1,2,2,2,null,2]
        /*String str = inOrder(root);
        if (str.length() < 2) {
            return true;
        }
        if (str.length() % 2 == 0) {
            return false;
        }
        int mid = str.length() / 2;
        String str1 = str.substring(0, mid);
        String str2 = new StringBuilder(str.substring(mid + 1)).reverse().toString();
        return str1.equals(str2);*/
        if (root == null) {
            return true;
        }

        return isEqual(root.left, root.right);

    }
    private boolean isEqual (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null) ^ (right == null)) {
            return false;
        }
        if (left.val == right.val) {
            return isEqual(left.left, right.right) && isEqual(left.right, right.left);
        } else {
            return false;
        }

    }

    private String inOrder (TreeNode root) {
        if (root == null) {
            return "";
        }
        return inOrder(root.left) + root.val + inOrder(root.right);
    }

}
