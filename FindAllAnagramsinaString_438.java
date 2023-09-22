import java.util.*;
public class FindAllAnagramsinaString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int[] map = new int[26];

        for (char c : p.toCharArray()) {
            map[c-'a']++;
        }

        int left =0, right =0;

        while (right < s.length()) {
            if (map[s.charAt(right)-'a'] > 0) {
                map[s.charAt(right)-'a']--;
                right++;

                if (right-left == p.length()) {
                    res.add(left);
                }
            }else if (left == right) {
                left++;
                right++;
            }else {
                map[s.charAt(left)-'a'] ++;
                left++;
            }
        }
        return res;
    }
}
