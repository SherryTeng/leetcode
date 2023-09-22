import java.util.*;
public class TopKFrequentElements_347 {
//    //Solution 1:heap
//    public int[] topKFrequent(int[] nums, int k) {
//
//        //构建map（key:num, value: frequency）
//        Map<Integer,Integer> freq = new HashMap<>();
//        for (int num:nums) {
//            freq.put(num, freq.getOrDefault(num, 0)+1);
//        }
//
//        //建立一个maxHeap，把map的key按照value的大小放到heap里
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> freq.get(b)- freq.get(a));
//        for(int key: freq.keySet()) {
//            pq.add(key);
//        }
//
//        int[] res = new int[k];
//        for (int i = 0; i<k; i++) {
//            res[i] = pq.remove();
//        }
//        return res;
//    }

    //Solution 2:quickSelect
    Map<Integer, Integer> count;
    int[] unique;
    public int[] topKFrequent(int[] nums, int k) {
        count = new HashMap<>();
        for  (int num: nums){
            count.put(num, count.getOrDefault(num,0)+1);
        }
        int n = count.size();
        unique = new int[n];
        int i = 0;
        for (int num: count.keySet()) {
            unique[i] = num;
            i++;
        }
        quickSelect(0, n-1, n-k);

        return Arrays.copyOfRange(unique, n-k, n);

    }

    public void quickSelect(int l, int r, int k_smallest) {
        if (l>=r) return;
        Random random_num = new Random();
        int pIndex = l+random_num.nextInt(r-l);
        pIndex = partition(l,r, pIndex);
        if (k_smallest == pIndex) {
            return;
        }else if (k_smallest < pIndex) {
            quickSelect(l, pIndex-1, k_smallest);
        }else {
            quickSelect(pIndex+1, r, k_smallest);
        }
    }
    public int partition(int l, int r, int p_Index) {
        int pivot_freq = count.get(unique[p_Index]);
        swap(p_Index, r);
        int i = l;
        for (int j = l; j <=r; j++) {
            if (count.get(unique[j]) < pivot_freq) {
                swap(i, j);
                i++;
            }
        }
        swap(i, r);
        return i;

    }

    public void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }


}
