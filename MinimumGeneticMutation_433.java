import java.util.*;

public class MinimumGeneticMutation_433 {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        Set<String> bankSet = new HashSet<>();
        for (String b: bank) {
            bankSet.add(b);
        }
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        q.add(startGene);
        visited.add(startGene);
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.remove();
                if(curr.equals(endGene)) return count;

                char[] currArray = curr.toCharArray();
                for (int j = 0; j < currArray.length; j++) {
                    char old = currArray[j];
                    for (char c: charSet) {
                        currArray[j] = c;
                        String next = new String(currArray);
                        if (!visited.contains(next) && bankSet.contains(next))  {
                            q.add(next);
                            visited.add(next);
                        }
                    }
                    currArray[j] = old;
                }
            }
            count++;
        }

        return -1;

    }
}
