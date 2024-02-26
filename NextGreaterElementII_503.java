import java.util.*;
public class NextGreaterElementII_503 {
    public int[] nextGreaterElements(int[] nums) {

        int  n = nums.length;
        int[] res =new int[n];

        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i =0; i < n*2; i++ ) {
            int num = nums[i%n];
            while (!stack.isEmpty() && num > stack.peek()){

                res[stack.pop()] = num;
            }
            stack.push(i%n);
        }

        return res;

    }
}
