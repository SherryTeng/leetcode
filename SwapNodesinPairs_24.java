public class SwapNodesinPairs_24 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode swapPairs(ListNode head) {
      if (head == null) return null;
      if (head.next == null) return head;

      ListNode dummy = new ListNode();
      ListNode prev = dummy;
      ListNode curr = head;

      while (curr!= null && curr.next != null){
        ListNode temp = curr.next.next;

        prev.next = curr.next;
        curr.next = curr.next.next;
        prev.next.next = curr;

        prev = curr;
        curr = temp;

      }

      return dummy.next;

    }

}
