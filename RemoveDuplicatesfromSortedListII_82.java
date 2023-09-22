public class RemoveDuplicatesfromSortedListII_82 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;


        while (curr != null) {
            while(curr.next!= null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            if (pre.next == curr) {
                pre = pre.next;
            }else {
                pre.next = curr.next;
            }

            curr = curr.next;


        }

        return dummy.next;

    }

}
