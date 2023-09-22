public class PartitionList_86 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode partition(ListNode head, int x) {

      ListNode dummy = new ListNode();

      dummy.next = head;
      ListNode leftPre = dummy;
      ListNode pre = dummy;
      ListNode curr = head;
      while (curr != null) {
        while (curr != null && curr.val >= x) {
          pre = pre.next;
          curr = curr.next;
        }

        if (curr!= null && leftPre != pre) {
          ListNode temp = curr.next;
          curr.next = leftPre.next;
          leftPre.next = curr;
          pre.next = temp;
          curr = temp;
          leftPre = leftPre.next;

        }else if (curr != null) {
          leftPre = leftPre.next;
          pre = pre.next;
          curr = curr.next;

        }
      }

      return dummy.next;

    }


}
