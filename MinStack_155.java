import java.util.Stack;

public class MinStack_155 {
    private Stack<int[]> stack;
    public MinStack_155() {
        stack= new Stack<>();

    }

    public void push(int val) {

        if (stack.isEmpty()) {
            stack.push(new int[] {val,val});
        }else{
            int min = stack.peek()[1];
            stack.push(new int[] {val, Math.min(min, val)});
        }
    }

    public void pop() {

        stack.pop();
    }

    public int top() {

        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];

    }
}
