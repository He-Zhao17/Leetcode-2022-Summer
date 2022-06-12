import java.util.Stack;

public class E297_SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        return preOrder(root);
    }
    private String preOrder (TreeNode root) {
        if (root == null) {
            return "None";
        }
        return root.val + " " + preOrder(root.left) + " " + preOrder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] arr = data.split(" ");
        Stack<TreeNode> sta = new Stack<>();
        sta.push(new TreeNode(Integer.parseInt(arr[0])));
        int i = 1;
        Boolean k = false;
        while (!sta.isEmpty()) {
            if (arr[i].equals("None")) {
                i++;
                if (arr[i].equals("None")) {

                }
            }

        }






    }
    private TreeNode deserializeSubtree (String data) {

    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));