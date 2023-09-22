public class ReverseWordsInaStringIII_557 {
    public static String reverseWords(String s) {
        s = s + " ";
        int j =0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                int k = i-1;

                while (k >=j) {

                     sb.append(s.charAt(k));
                     k--;
                }
                sb.append(' ');
                j =i+1;
            }


        }
        String res = sb.toString();
        res = res.strip();
        return res;

    }
    public static void main(String[] args){
        reverseWords("Let's take LeetCode contest");
    }
}
