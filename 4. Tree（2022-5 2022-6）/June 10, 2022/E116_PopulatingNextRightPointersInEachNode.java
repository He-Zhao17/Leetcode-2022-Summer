import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class E116_PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null ){
            return root;
        }
        Queue<Node> que = new LinkedList<>();
        int p = 0;
        Node curr = root;
        que.offer(root);
        while (!que.isEmpty()) {
            int size = (int) Math.pow(2, p);
            for (int i = 0; i < size; ++i) {
                curr = que.poll();
                if (i == size - 1) {
                    curr.next = null;
                } else {
                    curr.next = que.peek();
                }
                if (curr.left != null) {
                    que.offer(curr.left);
                }
                if (curr.right != null) {
                    que.offer(curr.right);
                }
            }
            p++;
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Node curr = root;
        curr.next = null;
        while (curr.left != null) {
            Node start = curr.left;
            while (curr.next != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next.left;
                curr = curr.next;
            }
            curr.left.next = curr.right;
            curr.right.next = null;
            curr = start;
        }
        return root;
    }
}

