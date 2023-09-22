public class OddEvenLinkedList_328 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode oddEvenList(ListNode head) {

      if (head == null || head.next == null) return head;

      ListNode odd = head;
      ListNode even = head.next;

      ListNode evenHead = head.next;

      while (odd.next != null &&odd.next.next != null && even.next != null) {
        ListNode tempOdd = odd.next.next;
        ListNode tempEven = even.next.next;
        odd.next = tempOdd;
        even.next = tempEven;

        odd = tempOdd;
        even = tempEven;


      }

      odd.next = evenHead;

      return head;



    }
}
