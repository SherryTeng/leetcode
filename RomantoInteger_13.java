import java.util.*;

public class RomantoInteger_13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        Map<String, Integer> sub = new HashMap<>();
        sub.put("IV", 4);
        sub.put("IX", 9);
        sub.put("XL", 40);
        sub.put("XC", 90);
        sub.put("CD", 400);
        sub.put("CM", 900);

        int i = 0;
        int res = 0;
        while (i < s.length()-1) {
            if (sub.containsKey(s.substring(i, i+2))) {
                res += sub.get(s.substring(i, i+2));
                i = i+2;
            }else {
                res += map.get(s.charAt(i));
                i++;
            }
        }

        if (i != s.length()-1) {
            res += map.get(s.charAt(s.length()-1));
        }

        return res;





    }
}
