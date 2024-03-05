import java.util.*;

public class RepeatedDNASequences_187 {
    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> seen  = new HashSet<>();
        Set<String> res = new HashSet<>();

        for (int i = 0; i < s.length()-9; i++){
            String ten = s.substring(i, i+10);

            if (!seen.contains(ten)){
                seen.add(ten);
            }else {
                res.add(ten);
            }
        }

        return new ArrayList<>(res);


    }
}
