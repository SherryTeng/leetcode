import java.util.*;
import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        int a, b;
        int res;
        for (String s: tokens) {
            if (s.equals("+")){
                a = stack.pop();
                b = stack.pop();
                res = b+a;
                stack.add(res);

            }else if (s.equals("-")){
                a = stack.pop();
                b = stack.pop();
                res = b-a;
                stack.add(res);

            }else if (s.equals("*")){
                a = stack.pop();
                b = stack.pop();
                res = b*a;
                stack.add(res);

            }else if (s.equals("/")) {
                a = stack.pop();
                b = stack.pop();
                res = b/a;
                stack.add(res);

            }else{
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();


    }
}
