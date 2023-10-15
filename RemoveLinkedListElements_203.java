public class RemoveLinkedListElements_203 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;


        while (curr!= null){
            ListNode temp = curr.next;
            if (curr.val == val) {
                prev.next = curr.next;
            }else{
                prev = curr;
            }

            curr = temp;
        }

        return dummy.next;

    }

}
