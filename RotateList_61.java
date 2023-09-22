public class RotateList_61 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode rotateRight(ListNode head, int k) {
      if (head == null) return null;


      ListNode dummy = new ListNode();
      dummy.next = head;
      ListNode left = head;
      ListNode right = head;

      //1. get length n
      int n = 1;
      while (right.next!=null) {
        right = right.next;
        n++;
      }

      k = k%n;

      //2. get the position of slow
      for (int j = 0; j<n-k-1; j++) {
        left = left.next;
      }

      //3. do the rotation
      right.next = dummy.next;
      dummy.next = left.next;
      left.next = null;

      return dummy.next;


    }


}
