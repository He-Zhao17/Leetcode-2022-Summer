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
public class E117_PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        root.next = null;
        Node curr = root;

        while (curr != null) {
            Node start = null;
            Node prev = null;
            while (curr != null) {
                if (curr.left != null) {
                    if (start == null) {
                        start = curr.left;
                    }
                    if (prev != null) {
                        prev.next = curr.left;
                    }
                    if (curr.right != null) {
                        curr.left.next = curr.right;
                        prev = curr.right;
                    } else {
                        prev = curr.left;
                    }
                } else {
                    if (curr.right != null) {
                        if (start == null) {
                            start = curr.right;
                        }
                        if (prev != null) {
                            prev.next = curr.right;
                        }
                        prev = curr.right;
                    }
                }
                curr = curr.next;
            }
            if (prev != null) {
                prev.next = null;
            }
            curr = start;
        }
        return root;
    }
}
