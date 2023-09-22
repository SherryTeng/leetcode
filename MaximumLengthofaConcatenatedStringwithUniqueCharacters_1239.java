import java.util.*;
public class MaximumLengthofaConcatenatedStringwithUniqueCharacters_1239 {
    int max = 0;
    public int maxLength(List<String> arr) {
        String str = "";
        backtrack(0, str, arr);
        return max;

    }
    private void backtrack(int start, String str, List<String> arr) {
        boolean unique = isUnique(str);
        if (unique) {
            max = Math.max(max, str.length());
        }
        if (start >= arr.size() ||!isUnique(str)) {
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            str = str + arr.get(i);
            backtrack(i+1, str, arr);
            str = str.substring(0, str.length()-arr.get(i).length());
        }

    }

    private boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
