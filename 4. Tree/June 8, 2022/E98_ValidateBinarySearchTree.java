public class E98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelp(root)[0] == 1;

    }
    private int[] isValidBSTHelp (TreeNode root) {
        if (root == null) {
            return new int[] {1};
        }
        int[] l = isValidBSTHelp(root.left);
        if (l[0] == 0) {
            return new int[] {0};
        }
        int[] r = isValidBSTHelp(root.right);
        if (r[0] == 0) {
            return new int[] {0};
        }
        if ( (l.length > 1 && l[2] >= root.val) || (r.length > 1 && r[1] <= root.val) ) {
            return new int[] {0};
        } else {
            int min, max;
            min = l.length > 1 ? l[1] : root.val;
            max = r.length > 1 ? r[2] : root.val;
            return new int[] {1, min, max};
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        E98_ValidateBinarySearchTree temp = new E98_ValidateBinarySearchTree();
        int[] ans = temp.isValidBSTHelp(root);
        for (int i = 0; i < ans.length; ++i) {
            System.out.print(ans[i] + " ");
        }

    }


}
