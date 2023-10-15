public class RemoveDuplicatesfromSortedList_83 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteDuplicates(ListNode head) {

      if (head == null) return null;

      ListNode curr = head;

      while (curr != null) {
        if (curr.next == null) {
          break;
        }

        if (curr.val == curr.next.val){
          curr.next = curr.next.next;
        }else {
          curr = curr.next;
        }

      }
      return head;


    }


}
