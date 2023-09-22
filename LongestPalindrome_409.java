import java.util.HashSet;

public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                count++;
                set.remove(c);
            }else {
                set.add(c);
            }
        }

        if (set.isEmpty()) return count*2;
        return count*2+1;

    }
}
