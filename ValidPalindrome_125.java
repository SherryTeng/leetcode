import java.util.Locale;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String l = "";
        int k = 0;
        while (k < s.length()) {
            if (isAlphanumeric(s.charAt(k))){
                l += s.charAt(k);
                k++;
            }else {
                k++;
            }
        }

        int i = 0;
        int j = l.length()-1;

        while (i <= j) {
            if (l.charAt(i) != l.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;



    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <='z') || (c >='0' && c <='9');
    }
}
