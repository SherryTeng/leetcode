public class MaximumTwinSumofaLinkedList_2130 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public int pairSum(ListNode head) {
      if (head.next.next== null) {
        return head.val + head.next.val;
      }

      ListNode slow  = head;
      ListNode fast = head;
      ListNode prev = new ListNode();
      prev.next = head;

      while (fast!= null && fast.next != null) {
        prev = prev.next;
        slow = slow.next;
        fast = fast.next.next;
      }

      prev.next = null;

      ListNode dummy = new ListNode();
      ListNode preReverse = dummy;
      dummy.next =slow;

      while (slow != null) {
        ListNode temp = slow.next;
        slow.next = preReverse;
        preReverse = slow;
        slow = temp;
      }

      int sum = 0;

      while (preReverse!= null && head != null) {
        sum = Math.max(sum, preReverse.val+head.val);
        preReverse = preReverse.next;
        head = head.next;

      }

      return sum;

    }

}
