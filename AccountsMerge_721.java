import java.util.*;
public class AccountsMerge_721 {


    /**
     * Methods1: Union and Find
     *
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parents = new HashMap<>();
        Map<String, String> owner =  new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();

        //set each account's parent to itself
        for (List<String> accs : accounts) {
            for (int i = 1; i < accs.size(); i++) {
                parents.put(accs.get(i), accs.get(i));
                owner.put(accs.get(i),accs.get(0));
            }
        }

        //set each account's parent to the first account
        for (List<String> accs: accounts) {
            String parent = find(accs.get(1), parents);
            for (int i = 2; i < accs.size(); i++) {
                parents.put(find(accs.get(i), parents), parent);
            }
        }

        for (List<String> accs: accounts) {
            String parent = find(accs.get(1), parents);
            if (!unions.containsKey(parent)) unions.put(parent, new TreeSet<>());
            for (int i =1; i < accs.size(); i++) {
                unions.get(parent).add(accs.get(i));
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String parent: unions.keySet()) {
            List<String> emails = new ArrayList<>(unions.get(parent));
            emails.add(0, owner.get(parent));
            res.add(emails);
        }
        return res;


    }

    private String find(String account, Map<String, String> parents) {
        if (parents.get(account).equals(account)) {
            return account;
        }else {
            return find(parents.get(account), parents);
        }
    }


    /**
     * Methods2: Graph + DFS
     *
     */
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        Map<String, Set<String>> graph = new HashMap<>();
//        Map<String, String> owner = new HashMap<>();
//
//        for (List<String> accs: accounts) {
//            for (int i = 1; i < accs.size(); i++) {
//                owner.put(accs.get(i), accs.get(0));
//                if (!graph.containsKey(accs.get(i))) graph.put(accs.get(i), new HashSet<>());
//                if (i == 1) continue;
//                graph.get(accs.get(i)).add(accs.get(i-1));
//                graph.get(accs.get(i-1)).add(accs.get(i));
//            }
//        }
//
//        Set<String> visited  = new HashSet<>();
//        List<List<String>> res = new ArrayList<>();
//
//        for (String email: owner.keySet()) {
//            List<String> list = new ArrayList<>();
//            if (visited.add(email)){
//                dfs(graph, email, visited, list);
//                Collections.sort(list);
//                list.add(0, owner.get(email));
//                res.add(list);
//            }
//        }
//
//        return res;
//    }
//
//    private void dfs(Map<String, Set<String>> graph, String email,Set<String> visited, List<String> list) {
//        list.add(email);
//        for (String next: graph.get(email)) {
//            if (visited.add(next)) dfs(graph, next, visited, list);
//        }
//
//
//    }
}
