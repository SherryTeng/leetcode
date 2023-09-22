public class LengthofLastWord_58 {
    public int lengthOfLastWord(String s) {

        s = s.trim();
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                res = 0;
            }else{
                res++;
            }
        }

        return res;

    }
}
