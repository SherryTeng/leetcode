import java.util.*;
public class DestinationCity_1436 {
    public String destCity(List<List<String>> paths) {

        String res = "";
        Set<String> set = new HashSet<>();
        for (List<String> path: paths){
            set.add(path.get(0));

        }

        for (List<String> path: paths){
            if (!set.contains(path.get(1))){
                res = path.get(1);
                break;
            }

        }
        return res;



    }
}
