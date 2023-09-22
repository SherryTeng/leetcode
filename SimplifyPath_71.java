
import java.util.*;
public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] strs = path.split("/");

        for (String str:strs) {
            if (!stack.isEmpty() && str.equals("..")) {
                stack.pop();
            }else if (!str.equals(".") && !str.equals("") && !str.equals("..")) {
                stack.push(str);
            }
        }

        // Convert stack to list
        List<String> list = new ArrayList(stack);
        return "/"+String.join("/", list);


    }
}
