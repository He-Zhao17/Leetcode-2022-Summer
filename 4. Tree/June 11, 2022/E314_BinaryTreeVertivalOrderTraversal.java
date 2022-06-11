import com.sun.source.tree.Tree;

import java.util.*;

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

public class E314_BinaryTreeVertivalOrderTraversal {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        min = 0;
        max = 0;
        Queue<TreeNode> que = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        que.offer(root);
        map.put(0, temp);
        temp = new ArrayList<Integer>();
        temp.add(0);
        while (!que.isEmpty()) {
            int len = que.size();
            ArrayList<Integer> temp1 = new ArrayList<>();
            for (int i = 0; i < len; ++i) {
                TreeNode curr = que.poll();
                int index = temp.get(i);
                if (curr.left != null) {
                    min = index - 1 < min ? index - 1 : min;
                    max = index - 1 > max ? index - 1 : max;
                    que.offer(curr.left);
                    temp1.add(index - 1);
                    ArrayList<Integer> arr = map.containsKey(index - 1) ? map.get(index - 1) : new ArrayList<Integer>();
                    arr.add(curr.left.val);
                    map.put(index - 1, arr);
                }
                if (curr.right != null) {
                    min = index + 1 < min ? index + 1 : min;
                    max = index + 1 > max ? index + 1 : max;
                    que.offer(curr.right);
                    temp1.add(index  + 1);
                    ArrayList<Integer> arr = map.containsKey(index + 1) ? map.get(index + 1) : new ArrayList<Integer>();
                    arr.add(curr.right.val);
                    map.put(index + 1, arr);
                }
            }
            temp = temp1;
        }
        for (int i = min; i <= max; ++i) {
            if (map.containsKey(i)) {
                ans.add(map.get(i));
            }
        }
        return ans;

    }

}
