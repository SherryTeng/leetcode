package SlidingWindow;

public class LongestRepeatingCharacterReplacement_424 {

    public int characterReplacement(String s, int k){

        int[] freq = new int[26];

        int res = 0;

        int i = 0;

        int mostFreq = 0;

        for (int j = 0; j < s.length(); j++) {
            freq[s.charAt(j)-'A']++;

            mostFreq = Math.max(mostFreq, freq[s.charAt(j)-'A']);

            int numOflettersToChange = j-i+1-mostFreq;

            if(numOflettersToChange > k) {
                freq[s.charAt(i)-'A']--;
                i++;
            }

            res = Math.max(res, j-i+1);

        }

        return res;

    }
}
