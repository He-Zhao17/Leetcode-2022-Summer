import java.util.*;

/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-06-02 11:24
 */
public class E113_PathSumII {

    /*public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        Queue<Integer> qRes = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        queueNode.offer(root);
        queue.offer(new ArrayList<Integer>(root.val));
        qRes.offer(root.val);

        while (!queueNode.isEmpty()) {
            TreeNode curr = queueNode.poll();
            List<Integer> list = queue.poll();
            int num = qRes.poll();

            if (curr.left == null && curr.right == null) {
                if (num == targetSum) {
                    ans.add(list);
                }
            } else {
                if (curr.left != null) {
                    queueNode.offer(curr.left);
                    list.add(curr.left.val);
                    queue.offer(list);
                    qRes.offer(num + curr.left.val);
                }
                if (curr.right != null) {
                    queueNode.offer(curr.right);
                    list.add(curr.right.val);
                    queue.offer(list);
                    qRes.offer(num + curr.right.val);
                }
            }
        }
        return ans;

    }*/

    //答案 回溯算法
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        if(root == null){
            return res;
        }

        dfs(res,path,root,0,targetSum);
        return res;
    }

    public void dfs(List<List<Integer>> res,LinkedList<Integer> path,TreeNode root,int preSum,int targetSum){
        if(root == null){
            return;
        }
        path.addLast(root.val);
        preSum += root.val;
        if(preSum == targetSum){
            //按题目要求只要叶子结点
            if(root.left == null && root.right == null){
                res.add(new ArrayList<>(path));
            }

        }
        dfs(res,path,root.left,preSum,targetSum);

        dfs(res,path,root.right,preSum,targetSum);

        path.removeLast();
    }

}
