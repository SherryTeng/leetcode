import java.util.Stack;

public class DecodeString_394 {
    int i = 0;
    public String decodeString(String s) {

        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;

//        StringBuilder sb = new StringBuilder();
//        while (i < s.length() && s.charAt(i) != ']') {
//            if (!Character.isDigit(s.charAt(i))) {
//                sb.append(s.charAt(i));
//                i++;
//            }else {
//                int k = 0;
//                while(i < s.length() &&Character.isDigit(s.charAt(i))){
//                    k = k*10+s.charAt(i)-'0';
//                    i++;
//                }
//                i++;
//                String decodedString = decodeString(s);
//                i++;
//                while (k-->0) {
//                    sb.append(decodedString);
//                }
//            }
//        }
//        return new String(sb);

    }
}
