public class TwoSumII_InputArrayIsSorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] res = new int[2];
        for (int i =0; i < n-1; i++) {
            int j = i+1;

            while (j <= n-1) {
                int sum = numbers[i] + numbers[j];
                if (sum == target){
                    res[0] = i+1;
                    res[1] = j+1;
                    break;
                }else if (sum < target){
                    j++;
                }else {
                    break;
                }
            }
        }
        return res;

    }
}
