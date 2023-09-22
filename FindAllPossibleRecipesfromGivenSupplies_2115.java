import java.awt.font.GraphicAttribute;
import java.util.*;
public class FindAllPossibleRecipesfromGivenSupplies_2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        List<String> res =  new ArrayList<>();

        Set<String> available = new HashSet<>();
        for (String supply: supplies) {
            available.add(supply);
        }
        int n = recipes.length;
        Map<String, Integer> index = new HashMap<>();
        for (int i =0; i < n; i++) {
            index.put(recipes[i],i);
        }

        int[] indegree = new int[n];
        Map<String, List<String>> map = new HashMap<>();
        for (int i =0; i < n; i++) {
            for (String need : ingredients.get(i)) {
                if (available.contains(need)) continue;
                map.putIfAbsent(need, new ArrayList<>());
                map.get(need).add(recipes[i]);
                indegree[i]++;

            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i < n; i++) {
            if (indegree[i]==0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int i = q.remove();
            res.add(recipes[i]);

            if (!map.containsKey(recipes[i])) continue;

            for (String recipe: map.get(recipes[i])) {
                indegree[index.get(recipe)]--;
                if (indegree[index.get(recipe)] == 0) {
                    q.add(index.get(recipe));
                }
            }
        }

        return res;


    }
}
