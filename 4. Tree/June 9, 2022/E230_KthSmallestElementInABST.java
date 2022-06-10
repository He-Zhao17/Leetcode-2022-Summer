import java.util.Stack;

public class E230_KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> sta = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            sta.push(curr);
            curr = curr.left;
        }
        for (int i = 0; i < k - 1; i++) {
            curr = sta.pop();
            curr = curr.right;
            while (curr != null){
                sta.push(curr);
                curr = curr.left;
            }
        }
        return sta.peek().val;

    }

}
