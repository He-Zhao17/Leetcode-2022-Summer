
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
public class E82_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null) {
                if (curr.next.val == curr.val) {
                    int t = curr.val;
                    curr = curr.next;
                    while (curr != null) {
                        if (curr.next == null) {
                            break;
                        }
                        if (curr.next.val == curr.val) {
                            curr = curr.next;
                        } else {
                            break;
                        }
                    }
                    if (curr.next == null) {
                        if (prev == null) {
                            return null;
                        } else {
                            prev.next = null;
                            return head;
                        }
                    } else {
                        if (prev == null) {
                            head = curr.next;
                        } else {
                            prev.next = curr.next;
                        }
                        curr = curr.next;
                    }
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return head;

    }

}
