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

public class InsertionSortList_147 {

    public static class ListNode {
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

    public static ListNode insertionSortList(ListNode head) {

//        //iteration method
//        //use dummy node to handle edge case
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode dummy = new ListNode(0, head);
//        ListNode prev = head;
//        ListNode curr = head.next;
//
//        while (curr != null) {
//            if (curr.val >= prev.val) {
//                prev = curr;
//                curr = curr.next;
//                continue;
//            }
//
//            ListNode temp = dummy;
//            while (curr.val > temp.next.val) {
//                temp = temp.next;
//            }
//            prev.next = curr.next;
//            curr.next = temp.next;
//            temp.next = curr;
//            curr = prev.next;
//        }
//
//
//        return dummy.next;


        //recursion

        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = insertionSortList(head.next);
        if (head.val <= p.val) {  // already sorted
            head.next = p;
            return head;
        }
        ListNode ret = p;
        while (p.next != null && p.next.val < head.val) {
            p = p.next;
        }
        head.next = p.next;
        p.next = head;

        return ret;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode reversed = insertionSortList(test);
        System.out.println(reversed);
    }
}
