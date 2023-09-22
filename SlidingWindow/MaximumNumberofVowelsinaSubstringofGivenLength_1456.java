package SlidingWindow;

import java.util.*;

public class MaximumNumberofVowelsinaSubstringofGivenLength_1456 {
    public int maxVowels(String s, int k) {

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');



        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }

        int maxCount = count;

        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i-k))) {
                count--;
            }

            if (vowels.contains(s.charAt(i))){
                count++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;

    }
}
