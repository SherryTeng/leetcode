import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReverseLinkedLIst_206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
//        //iteration
//        ListNode curr =  head;
//        ListNode newHead = null;
//        ListNode temp;
//
//        while (curr != null) {
//            temp = curr.next;
//            curr.next = newHead;
//            newHead = curr;
//            curr = temp;
//        }
//
//        return newHead;

        //recursion
        //base case
        if (head == null || head.next == null) return head;

        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }

//    public static void main(String[] args) {
//        ListNode test = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
//        ListNode reversed = reverseList(test);
//        System.out.println(reversed);
//    }
}


