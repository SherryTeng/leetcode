public class LongestRepeatingCharacterReplacement_424 {
    /*
       A running example:

      A B C A B S   k=2
      i
        j

      maxFreq = 0

      len - maxFreq = 1-1=0 <=k
      {A: 1;
       B: 1;
      }

      data structure:

        */
    public int characterReplacement(String s, int k) {

        int i = 0;


        int res = 0;

        int mostFreq = 0;

        int[] count = new int[26];


        for (int j = 0; j < s.length(); j++){
            count[s.charAt(j) - 'A']++;

            mostFreq = Math.max(mostFreq, count[s.charAt(j)-'A']);

            if (j-i+1 - mostFreq > k){
                count[s.charAt(i)-'A']--;
                i++;
            }

            res = Math.max(res, j-i+1);
        }
        return res;


    }
}
