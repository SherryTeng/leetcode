import java.util.*;

public class RemovingStarsFromaString_2390 {
    public String removeStars(String s) {

        StringBuilder c = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                c.deleteCharAt(c.length() - 1);
            } else {
                c.append(s.charAt(i));
            }
        }
        return c.toString();



//        List<Character> res = new ArrayList<>();
//
//        Stack<Character> stack = new Stack<>();
//        int k = 0;
//        while ( k < s.length()) {
//            if (s.charAt(k) != '*') {
//                break;
//            }
//            k++;
//        }
//
//        for (int i = k; i < s.length(); i++) {
//            if(!stack.isEmpty() && s.charAt(i) == '*'){
//                stack.pop();
//
//            }else if (s.charAt(i) != '*') {
//                stack.add(s.charAt(i));
//            }
//        }
//
//        if (stack.isEmpty()) return "";
//
//        while (!stack.isEmpty()) {
//            char c = stack.pop();
//            if (c != '*') {
//                res.add(0, c);
//            }
//        }
//
//        String ans = "";
//
//        for (char c: res) {
//            ans += c;
//        }
//
//        return ans;

    }
}
