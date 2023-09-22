public class AddTwoNumbers_2 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         Method1:

//          ListNode dummy = new ListNode(0);
//          ListNode curr = dummy;
//          int carry = 0;
//
//          while (l1 != null || l2 != null || carry !=0) {
//              int sum = 0;
//              if (l1 != null) {
//                  sum += l1.val;
//                  l1 = l1.next;
//              }
//              if (l2 != null) {
//                  sum += l2.val;
//                  l2 = l2.next;
//              }
//
//              sum += carry;
//              carry = sum/10;
//              ListNode node  = new ListNode(sum%10);
//              curr.next = node;
//              curr=curr.next;
//          }
//
//
//          return dummy.next;

//        Method 2:

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1!=null || l2 != null) {
            int l1_val = (l1!=null)? l1.val:0;
            int l2_val = (l2!=null)? l2.val:0;

            int currSum = l1_val+l2_val+carry;

            int digit = currSum % 10;

            carry = currSum/10;

            ListNode node= new ListNode(digit);
            curr.next = node;
            curr = curr.next;

            if (l1!= null) l1 = l1.next;
            if (l2!= null) l2 = l2.next;

        }

        if (carry ==1) {
            ListNode node = new ListNode(1);
            curr.next = node;
        }
        return dummy.next;
    }
}
