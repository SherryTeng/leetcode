import java.util.*;

public class EncodeAndDecodeStrings_271 {


    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length()).append('/').append(s);
        }

        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        List<String> res = new ArrayList<>();

        int i = 0;

        while(i < s.length()){
            int slashIndex = s.indexOf('/',i);

            int wordSize = Integer.parseInt(s.substring(i, slashIndex));

            i = slashIndex+ wordSize;

            res.add(s.substring(slashIndex+1, i+1));
        }

        return res;

    }
}
