public class AddTwoNumbersII_445 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        int carry = 0;

        while (rl1 != null || rl2 != null) {
            int rl1Val = (rl1 == null)? 0: rl1.val;
            int rl2Val = (rl2 == null)? 0: rl2.val;

            int sum = rl1Val+rl2Val+carry;

            int digit = sum % 10;
            carry = sum /10;

            ListNode node  = new ListNode(digit);
            prev.next = node;
            prev = node;

            if (rl1 != null) rl1 = rl1.next;
            if (rl2 != null) rl2 = rl2.next;

        }
        if (carry == 1){
            ListNode node  = new ListNode(1);
            prev.next = node;

        }

        return reverse(dummy.next);


    }

    private ListNode reverse(ListNode l){
        ListNode prev = null;
        ListNode curr = l;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
