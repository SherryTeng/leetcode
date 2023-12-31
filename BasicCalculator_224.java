import java.util.Stack;

public class BasicCalculator_224 {
    public int calculate(String s) {

        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;


//        Stack<Integer> stack = new Stack<Integer>();
//        int result = 0;
//        int number = 0;
//        int sign = 1;
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if(Character.isDigit(c)){
//                number = 10 * number + (int)(c - '0');
//            }else if(c == '+'){
//                result += sign * number;
//                number = 0;
//                sign = 1;
//            }else if(c == '-'){
//                result += sign * number;
//                number = 0;
//                sign = -1;
//            }else if(c == '('){
//                //we push the result first, then sign;
//                stack.push(result);
//                stack.push(sign);
//                //reset the sign and result for the value in the parenthesis
//                sign = 1;
//                result = 0;
//            }else if(c == ')'){
//                result += sign * number;
//                number = 0;
//                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
//                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
//
//            }
//        }
//        if(number != 0) result += sign * number;
//        return result;

    }
}
