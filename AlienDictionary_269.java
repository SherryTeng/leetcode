import java.util.*;

public class AlienDictionary_269 {

    public String alienOrder(String[] words) {

        if (words == null || words.length == 0) return "";
        //0. construct data structure for graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word: words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
                indegree.put(c,0);
            }
        }
        //1.construct graph

        for (int i =0; i < words.length-1; i++) {
            String curr = words[i];
            String next = words[i+1];

            if( curr.length() > next.length() && curr.startsWith(next) )
                return "";

            int length = Math.min(curr.length(), next.length());
            for (int j =0; j<length; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if (c1!=c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2,indegree.get(c2)+1 );
                    }
                    break;
                }
            }
        }
        String res = "";
        //2.BFS
        Queue<Character> q = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c)==0) {
                q.add(c);
            }
        }

        while (!q.isEmpty()) {
            char c = q.remove();
            res+=c;
            for (char n: graph.get(c)) {
                indegree.put(n, indegree.get(n)-1);
                if (indegree.get(n)==0) {
                    q.add(n);
                }
            }
        }

        if (res.length()!=indegree.size()) return "";

        return res;

    }
}
