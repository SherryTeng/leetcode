public class DeletetheMiddleNodeofaLinkedList_2095 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteMiddle(ListNode head) {

      if (head == null) return null;
      if (head.next == null) return null;

      ListNode slow = head;

      ListNode fast = head;
      ListNode dummy = new ListNode();
      dummy.next = head;
      ListNode prev = dummy;

      while (fast != null && fast.next != null) {
        prev = prev.next;
        slow = slow.next;
        fast = fast.next.next;
      }

      prev.next = slow.next;

      return dummy.next;




    }
}
