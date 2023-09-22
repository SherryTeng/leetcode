public class sortAnArray_912 {

    public int[] sortArray(int[] nums) {
        //build maxHeap
        for (int i = nums.length/2-1; i>=0; i--) {
            heapify(nums, i, nums.length);
        }

        //sort
        int heapSize = nums.length;
        for (int i = nums.length-1; i>=0; i--) {
            swap(nums, 0, i);
            heapSize--;
            heapify(nums, 0, heapSize);
        }

        return nums;
    }

    private void heapify(int[] nums, int i, int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if (left < size && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < size && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, largest, size);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    public int[] sortArray(int[] nums) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        for (int num: nums) {
//            minHeap.add(num);
//        }
//
//        int[] ascendingNums = new int[minHeap.size()];
//        int j=0;
//        while (!minHeap.isEmpty()) {
//            ascendingNums[j] = minHeap.remove();
//            j++;
//
//        }
//        return ascendingNums;
//
//    }

//    public static void main(String[] args) {
//        int[] sorted = sortArray(new int[]{5, 2, 3, 1});
//        for (int num : sorted) {
//            System.out.println(num);
//        }
//    }





}


