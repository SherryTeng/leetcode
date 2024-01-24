import java.util.*;
public class FindtheDifference_389 {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            }else {
                map.put(ch, 1);
            }
        }
        char res = 'a';
        for (int j = 0; j < t.length(); j++){
            char ch = t.charAt(j);

            if (!map.containsKey(ch)) {
                res = ch;
            }else {
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) < 0){
                    res = ch;
                }
            }
        }

        return res;

    }
}
