import java.util.Stack;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{' ) {
                stack.add(ch);

                //check stack is empty,
            }else if (stack.isEmpty()){
                return false;

                //optimization: use pop() instead of peek(), remove the last else statement
            }else if (ch == ')' && stack.peek() != '('){
                return false;
            }else if (ch == ']' && stack.peek() != '[') {
                return false;
            }else if (ch == '}' && stack.peek() != '{') {
                return false;
            } else {
                stack.pop();
            }

        }
        return stack.isEmpty();

    }
}
