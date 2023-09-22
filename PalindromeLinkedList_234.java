public class PalindromeLinkedList_234 {

      public class ListNode {
          int val;
          ListNode next;
         ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public boolean isPalindrome(ListNode head) {
          ListNode slow = head, fast = head, temp;
          while (fast != null && fast.next != null) {
              slow = slow.next;
              fast = fast.next.next;
          }

          ListNode prev = slow;
          slow = slow.next;
          prev.next = null;

          while (slow != null) {
              temp = slow.next;
              slow.next = prev;
              prev= slow;
              slow = temp;

          }

          while (prev != null ) {
              if (head.val!= prev.val) return false;
              head = head.next;
              prev = prev.next;
          }

          return true;

    }
}
