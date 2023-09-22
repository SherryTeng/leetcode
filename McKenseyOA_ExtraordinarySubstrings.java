import java.util.*;

public class McKenseyOA_ExtraordinarySubstrings {




    public static int extraSub(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 1);
        map.put('c', 2);
        map.put('d', 2);
        map.put('e', 2);
        map.put('f', 3);
        map.put('g', 3);
        map.put('h', 3);
        map.put('i', 4);
        map.put('j', 4);
        map.put('k', 4);
        map.put('l', 5);
        map.put('m', 5);
        map.put('n', 5);
        map.put('o', 6);
        map.put('p', 6);
        map.put('q', 6);
        map.put('r', 7);
        map.put('s', 7);
        map.put('t', 7);
        map.put('u', 8);
        map.put('v', 8);
        map.put('w', 8);
        map.put('x', 9);
        map.put('y', 9);
        map.put('z', 9);

        int count =0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i+1; j <= s.length(); j++) {
                String subS = s.substring(i,j);
                if (isExtraSub(subS, map)) count++;
            }
        }

        return count;

    }



    private static boolean isExtraSub(String s, Map<Character, Integer> map) {
        int sum = 0;
        for (int i= 0; i < s.length(); i++) {
            sum+= map.get(s.charAt(i));

        }
        return sum%s.length() == 0;
    }

    public static void main(String[] args) {
        String input = "abcd";
        int result = extraSub(input);
        System.out.println("Total number of extraordinary substrings: " + result);
    }

}
