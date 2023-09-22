public class ConvertSortedListtoBinarySearchTree_109 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode r = findRoot(head);
        ListNode left = head;
        ListNode temp = left;
        while (temp.next != r){
            temp = temp.next;
        }
        temp.next = null;
        ListNode right = r.next;
        TreeNode root = new TreeNode(r.val);
        root.left = sortedListToBST(left);
        root.right = sortedListToBST(right);
        return root;
    }

    private ListNode findRoot(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
