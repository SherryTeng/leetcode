import java.util.*;
public class GenerateParentheses_22 {
    static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        String str = "";
        backtrack(0, 0, str, n);
        return res;

    }
    private static void backtrack(int open, int close, String str, int n) {
        if (str.length() == n*2) {
            res.add(str);
            return;
        }

        if (open < n) {
            str +="(";
            open+=1;
            backtrack(open, close, str, n);
            str = str.substring(0, str.length()-1);
            open-=1;
        }

        if (close < open){
            str += ")";
            close+=1;
            backtrack(open, close, str, n);
            str = str.substring(0, str.length()-1);
            close-=1;
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);

    }
}
