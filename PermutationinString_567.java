public class PermutationinString_567 {
    public boolean checkInclusion(String s1, String s2) {

        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++){
            count[s1.charAt(i)-'a']++;
        }



        int i = 0;

        for (int j = 0; j < s2.length(); j++){
            char c = s2.charAt(j);

            count[c-'a']--;
            while (count[c-'a'] < 0){
                count[s2.charAt(i)-'a']++;
                i++;
            }

            if (j-i+1 == s1.length()){
                return true;
            }
        }
        return false;


    }
}
