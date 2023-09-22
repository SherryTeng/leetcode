import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


//      //Method1: Priority Queue
//      public ListNode mergeKLists(ListNode[] lists) {
//          if (lists==null || lists.length == 0) return null;
//
//          PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//              @Override
//              public int compare(ListNode o1, ListNode o2) {
//                  if(o1.val < o2.val) return -1;
//                  else if (o1.val == o2.val) return 0;
//                  else return 1;
//              }
//          });
//
//          for (ListNode node: lists) {
//              if (node != null) q.add(node);
//          }
//
//          ListNode dummy = new ListNode();
//          ListNode curr = dummy;
//          while (!q.isEmpty()) {
//              curr.next = q.poll();
//              curr = curr.next;
//
//              if (curr.next != null) {
//                  q.add(curr.next);
//              }
//
//          }
//
//          return dummy.next;
//      }


    //Method2: MergeSort

       public ListNode mergeKLists(ListNode[] lists) {
          if (lists == null || lists.length == 0) return null;
          return partition(lists, 0, lists.length-1);
      }

      private ListNode partition(ListNode[] lists, int l, int r) {
          if (l == r) return lists[l];

          int mid = l+ (r-l)/2;
          ListNode l1 = partition(lists, l, mid);
          ListNode l2 = partition(lists, mid+1, r);
          return merge(l1, l2);

      }

      private ListNode merge(ListNode l1, ListNode l2) {
           ListNode dummy = new ListNode();
           ListNode curr = dummy;
          while (l1 != null && l2 != null) {
              if (l1.val < l2.val) {
                  curr.next = l1;
                  curr = curr.next;
                  l1= l1.next;

              }else {
                  curr.next = l2;
                  curr = curr.next;
                  l2 = l2.next;
              }
          }



          if (l1 == null) curr.next = l2;
          if (l2 == null) curr.next = l1;

          return dummy.next;

////using recursion to merge two lists
//          if(l1==null) return l2;
//          if(l2==null) return l1;
//          if(l1.val<l2.val){
//              l1.next=merge(l1.next,l2);
//              return l1;
//          }else{
//              l2.next=merge(l1,l2.next);
//              return l2;
//          }

      }

}
