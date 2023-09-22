import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree_111 {

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


//      //BFS
//    public int minDepth(TreeNode root) {
//
//          if (root == null) return 0;
//
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        int depth =1;
//        while (!q.isEmpty()) {
//            int size = q.size();
//
//            for (int i=0; i < size; i++) {
//                TreeNode curr = q.remove();
//                if (curr.left == null && curr.right == null) {
//                    return depth;
//                }
//                if (curr.left != null) q.add(curr.left);
//
//                if (curr.right != null) q.add(curr.right);
//            }
//            depth++;
//
//        }
//
//        return depth;
//
//    }

    //DFS
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        int depth;
        if (left==0||right==0) {
            depth = left+right+1;
        }else {
            depth = Math.min(left, right) +1;
        }
        return depth;
    }

}
