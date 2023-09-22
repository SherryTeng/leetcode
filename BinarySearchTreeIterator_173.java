import java.util.*;
public class BinarySearchTreeIterator_173 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    TreeNode curr;
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator_173(TreeNode root) {
        curr = root;
        stack = new Stack<>();
    }

    public int next() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        TreeNode next = stack.pop();
        curr = curr.right;
        return next.val;

    }

    public boolean hasNext() {
        return curr != null || !stack.isEmpty();

    }


}
