

import java.util.Arrays;
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
public class E285_InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> sta = new Stack<>();
        TreeNode curr = root;
        sta.push(curr);

        while (!sta.isEmpty()) {
            if (sta.peek().val == p.val) {

                if (sta.peek().right != null) {
                    curr = sta.peek().right;
                    while (curr.left != null) {
                        curr = curr.left;
                    }
                    return curr;
                } else {
                    sta.pop();
                    if (sta.isEmpty()) {
                        return null;
                    } else {
                        return sta.pop();
                    }
                }
            }
            if (sta.peek().left != null) {
                curr = sta.peek().left;
                sta.peek().left = null;
                sta.push(curr);
            } else {
                if (sta.peek().right != null) {
                    curr = sta.peek().right;
                    sta.pop();
                    sta.push(curr);
                } else {
                    sta.pop();
                }
            }
        }
        return null;


    }

}
