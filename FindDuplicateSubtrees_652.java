import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees_652 {
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
  List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root, new HashMap<>());
        return res;

    }
    private String helper(TreeNode node, Map<String, Integer> map) {
        if (node == null) return "#";
        String serial =node.val + ',' + helper(node.left, map)  +  ',' + helper(node.right, map);
        map.put(serial, map.getOrDefault(serial, 0) +1);
        if (map.get(serial) == 2) res.add(node);
        return serial;

    }
}
