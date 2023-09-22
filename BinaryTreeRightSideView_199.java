
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
public class BinaryTreeRightSideView_199 {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i =0; i < size; i++) {
                TreeNode curr = q.remove();
                level.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }


            }
            int rightMost = level.getLast();
            res.add(rightMost);
        }

        return res;
    }

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode t1l = new TreeNode(2);
//        TreeNode t1r = new TreeNode(3);
//
//        root.left =  t1l;
//        root.right = t1r;
//
//        rightSideView(root);
//
//    }
}
