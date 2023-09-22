public class FindtheIndexoftheFirstOccurrenceinaString_28 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n= needle.length();

        for (int i =0; i < m; i++) {
            if (i+n > m) break;

            for (int j =0; j < n; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
                if (j==n-1) return i;
            }
        }

        return -1;

    }
}
