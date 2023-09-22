public class MiddleoftheLinkedList_876 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode middleNode(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;

      while (fast!= null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

      }
      return slow;

    }
}
