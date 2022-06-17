




public class E142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int c = 0;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            if (slow == fast) {
                break;
            }
        }
        while (true) {
            slow = slow.next;
            fast = fast.next.next;
            c++;
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        fast = head;
        for (int i = 0; i < c; ++i) {
            fast = fast.next;
        }
        while (true) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }

    }

    public static void main(String[] args) {
        int[] exp = new int[] {
                -1,-7,7,-4,19,6,-9,-5,-2,-5
        };
        int pos = 9;
        ListNode head = new ListNode();
        ListNode curr = head;
        ListNode posNode = head;
        for (int i = 0; i < exp.length; ++i) {
            curr.val = exp[i];
            if (i == pos) {
                posNode = curr;
            }
            curr.next = new ListNode();
            if (i == exp.length - 1) {
                curr.next = posNode;
            } else {
                curr = curr.next;
            }
        }

        E142_LinkedListCycleII temp = new E142_LinkedListCycleII();
        ListNode res = temp.detectCycle(head);
        System.out.println(res.val);
    }

}
