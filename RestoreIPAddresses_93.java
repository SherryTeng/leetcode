import java.util.*;

public class RestoreIPAddresses_93 {
    static List<String> res = new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {
        String str = "";
        backtrack(0, 0, str, s);
        return res;

    }
    private static void backtrack(int start, int k, String str, String s) {
        if (k >= 4 && start>= s.length()) {
            res.add(str.substring(0, str.length()-1));
            return;
        }
        if (k >=4) return;

        for (int i = start; i < start+3 && i < s.length(); i++) {
            String temp = s.substring(start, i+1);

            if (Integer.parseInt(temp)<= 255 && ( i == start || s.charAt(i) != '0')) {

                str = str + s.substring(start, i+1) + ".";
                backtrack(i+1, k+1, str, s);
                str = str.substring(0, str.length()-1-temp.length());



            }
        }

    }
    public static void main(String[] args) {
        restoreIpAddresses("101023");
    }
}
