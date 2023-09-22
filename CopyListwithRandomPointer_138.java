import java.util.*;

public class CopyListwithRandomPointer_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //key: original node containing all the information
        //val: new node with corresponding value
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);

        Node curr = head;

        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        Node res = map.get(head);
        while (head != null) {
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head = head.next;
        }
        return res;

    }


}
