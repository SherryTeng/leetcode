import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {

//        int res = 0;
//        int n = s.length();
//
//        int i = 0;
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (int j = 0; j < n; j++) {
//
//
//
//
//        }
//
//        return res;


        int res = 0;

        Set<Character> set = new HashSet<>();

        int n = s.length();
        int i = 0;

        for (int j = 0; j < n; j++) {
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j));
            res = Math.max(res, j-i+1);

        }

        return res;

    }
}
