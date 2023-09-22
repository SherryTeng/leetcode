public class CountCompleteTreeNodes_222 {
    public static class TreeNode {
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

    public static int countNodes(TreeNode root) {


         int h = height(root);
         if (h == 0) return 0;

         if (height(root.right) == h-1) {
             int right = countNodes(root.right);
             int tmp = (int) Math.pow(2, h-1);
             return right + tmp;
         }else {
             int left = countNodes(root.left);
             int tmp = (int)Math.pow(2, h-2);
             return left + tmp;
         }

    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        return height(root.left)+1;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        System.out.println(countNodes(node1));

    }
}
