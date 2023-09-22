import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle_141 {


      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
             val = x;
              next = null;
          }
      }
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode curr = head;
        while(curr != null) {
            if (nodeSet.contains(curr)) return true;
            nodeSet.add(curr);
            curr = curr.next;
        }

        return false;

    }
}
