import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaString_345 {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] ch= s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while(i <=j) {
            if (vowels.contains(ch[i]) && vowels.contains(ch[j]) ) {
                char temp = s.charAt(i);
                ch[i] = s.charAt(j);
                ch[j] = temp;
                i++;
                j--;
            }else if (vowels.contains(ch[i]) && !vowels.contains(ch[j])) {
                j--;
            }else if (!vowels.contains(ch[i]) && vowels.contains(ch[j])) {
                i++;
            }else if (!vowels.contains(ch[i]) && !vowels.contains(ch[j])) {
                i++;
                j--;
            }
        }

        return String.valueOf(ch);


    }
}
