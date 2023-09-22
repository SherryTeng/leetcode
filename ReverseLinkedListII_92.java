public class ReverseLinkedListII_92 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseBetween(ListNode head, int left, int right) {

      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode leftPre = dummy;
      ListNode curr = head;

      //1. find the leftNode
      int i = 1;
      while (i < left) {
        leftPre = leftPre.next;
        curr = curr.next;
        i++;
      }

      ListNode pre = null;
      ListNode temp = null;
      for (int j = 0; j < right-left+1; j++) {
        temp = curr.next;
        curr.next = pre;
        pre = curr;
        curr = temp;

      }

      leftPre.next.next = curr;
      leftPre.next = pre;

      return dummy.next;




    }

}
