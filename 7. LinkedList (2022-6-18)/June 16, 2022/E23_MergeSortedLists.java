public class E23_MergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }

        ListNode[] pointers = new ListNode[len];
        for (int i = 0; i < len; ++i) {
            if (lists[i] == null) {
                pointers[i] = null;
            } else {
                pointers[i] = lists[i];
            }
        }
        ListNode head = null;
        ListNode curr = head;
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < len; i++) {
                if (pointers[i] == null) {
                    continue;
                } else {
                    if (pointers[i].val < min) {
                        min = pointers[i].val;
                        minIndex = i;
                    }
                }
            }
            if (minIndex == -1) {
                break;
            }
            if (head == null) {
                head = pointers[minIndex];
                curr = head;
                pointers[minIndex] = pointers[minIndex].next;
            } else {
                curr.next = pointers[minIndex];
                pointers[minIndex] = pointers[minIndex].next;
                curr = curr.next;
            }
        }
        return head;

    }

}
