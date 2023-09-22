import java.util.ArrayList;
import java.util.List;

/**
 *          aab
 *        a   aa   aab
 */
public class PalindromePartitioning_131 {
    static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        List<String> substring = new ArrayList<>();
        backtrack(0, substring,s);
        return res;

    }

    private static void backtrack(int start, List<String> substring, String s) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(substring));
            return;
        }
        for (int i = start; i <s.length(); i++) {
            String temp = s.substring(start, i+1);
            if (isPalindrome(temp)) {
                substring.add(temp);
                backtrack(i+1, substring, s);
                substring.remove(substring.size()-1);
            }
        }


    }
    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }else{
                i++;
                j--;
            }
        }

        return true;
    }
    public static void main(String[] args) {

    }
}
