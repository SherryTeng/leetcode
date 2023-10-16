public class RemoveNthNodeFromEndofList_19 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {

      ListNode dummy = new ListNode();
      dummy.next = head;
      ListNode pre = dummy;
      ListNode left = head;
      ListNode right = head;

      //Move fast in front so that the gap between slow and fast becomes n
      for (int i = 0; i < n; i++) {
        right = right.next;
      }
      //Move fast to the end, maintaining the gap
      while (right != null) {
        left = left.next;
        right = right.next;
        pre = pre.next;
      }

      pre.next = left.next;

      return dummy.next;

    }

}
