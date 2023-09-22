import java.util.*;

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int i = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                if (map.get(s.charAt(j))>=0) {
                    count++;
                }
            }

            while (count == t.length()) {
                if (j-i+1 < minLength) {
                    minLength = j-i+1;
                    minLeft = i;
                }

                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                    if (map.get(s.charAt(i)) >0 ) {
                        count--;
                    }

                }

                i++;
            }
        }

        if(minLength > s.length()) return "";

        return s.substring(minLeft, minLeft+ minLength);


    }
}
