import java.util.*;

public class SubstringwithConcatenationofAllWords_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        int n = s.length();
        int len = words[0].length();

        for (int i = 0; i < n - words.length * len + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                String word = s.substring(i + j * len, i + (j + 1) * len);

                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == words.length) {
                res.add(i);
            }
        }
        return res;

    }
}
