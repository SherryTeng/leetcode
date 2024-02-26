import java.util.*;
public class DailyTempratures_739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[temperatures.length];

        for (int i = 0; i < res.length; i++){
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int idx = stack.pop();
                res[idx] = i-idx;
            }

            stack.push(i);
        }

        return res;


    }

    public static void main(String[] args){
        int[] temp = new int[]{73,74,75,71,69,72,76,73};

        dailyTemperatures(temp);
    }
}
