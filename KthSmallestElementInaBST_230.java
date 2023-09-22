import java.util.Stack;
public class KthSmallestElementInaBST_230 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //method1: DFS inOrder Traversal recursive;
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {

        inOrderTraverse(root, k);

        return result;

    }

    private void inOrderTraverse(TreeNode root, int k){

        if (root == null) return;

        inOrderTraverse(root.left, k);

        count++;

        if (count == k) {
            result = root.val;
        }

        inOrderTraverse(root.right, k);

    }

      //method2: DFS inOrder Traversal iterative
//    public int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> stack = new Stack<>();
//
//        int i = 0;
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.add(root);
//                root = root.left;
//            }

//            root = stack.pop();
//            i++;
//            if (i == k) {
//                return root.val;
//            }
//            root = root.right;
//        }
//
//        return 0;
//    }
}
