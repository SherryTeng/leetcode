import java.util.*;
public class LetterCombinationsofaPhoneNumber_17 {
    public static List<String> letterCombinations(String digits) {
        List<String> res  = new ArrayList<>();

        if (digits.length() == 0) return res;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "qprs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(res, map, digits,0, new StringBuilder());
        return res;

    }

    private static void backtrack(List<String> res, Map<Character, String> map, String digits, int start, StringBuilder path) {
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = map.get(digits.charAt(start));
        for (char letter: letters.toCharArray()) {
            path.append(letter);
            backtrack(res, map, digits, start+1, path);
            //Stringbuilder: delete a character
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        String test = "23";
        letterCombinations(test);
    }
}
