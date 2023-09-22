public class MergeStringsAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int i = 0;
        int j = 0;

        StringBuilder s = new StringBuilder();

        while (i < m && j < n) {
            s.append(word1.charAt(i));
            i++;
            s.append(word2.charAt(j));
            j++;

        }

        while (i < m) {
            s.append(word1.charAt(i));
            i++;
        }

        while (j < n) {
            s.append(word2.charAt(j));
            j++;
        }

        return s.toString();

    }
}
