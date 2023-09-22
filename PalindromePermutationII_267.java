import java.util.*;

public class PalindromePermutationII_267 {
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        // step 1. build character count map and count odds
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }

        // cannot form any palindromic string
        if (odd > 1) return res;

        // step 2. add half count of each character to list
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (val % 2 != 0) mid += key;

            for (int i = 0; i < val / 2; i++) list.add(key);
        }

        // step 3. generate all the permutations
        getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);

        return res;
    }

    // generate all unique permutation from list
    void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            // form the palindromic string
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            // avoid duplication
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;

            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                // recursion
                getPerm(list, mid, used, sb, res);
                // backtracking
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }





    //自己系的方法超时
//    Set<String> permu = new HashSet<>();
//    public List<String> generatePalindromes(String s) {
//
//
//        char[] charArray = s.toCharArray();
//        Arrays.sort(charArray);
//        String sorted = new String(charArray);
//        StringBuilder permutation = new StringBuilder();
//        boolean[] used = new boolean[sorted.length()];
//        backtrack(permutation, sorted, used);
//
//        List<String> res = new ArrayList<>();
//        for (String str: permu) {
//            if (isPalindrome(str)) {
//                res.add(str);
//            }
//        }
//        return res;
//
//    }
//    private void backtrack(StringBuilder permutation, String sorted, boolean[] used) {
//        if (permutation.length() >= sorted.length()) {
//            permu.add(permutation.toString());
//            return;
//        }
//
//        for (int i = 0; i < sorted.length(); i++) {
//            if (used[i]) continue;
//            if (i > 0 && sorted.charAt(i) == sorted.charAt(i-1) && !used[i-1]) continue;
//            permutation.append(sorted.charAt(i));
//            used[i] = true;
//            backtrack(permutation, sorted, used);
//            used[i] = false;
//            permutation.deleteCharAt(permutation.length()-1);
//        }
//    }
//
//    private static boolean isPalindrome(String s) {
//        int i = 0;
//        int j = s.length()-1;
//        while (i <= j) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }else{
//                i++;
//                j--;
//            }
//        }
//
//        return true;
//    }


}
