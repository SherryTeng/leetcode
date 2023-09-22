import java.util.*;
public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        q.add(beginWord);
        visited.add(beginWord);

        int res = 1;

        while (!q.isEmpty()){

            int size = q.size();

            for (int i = 0; i < size; i++){
                String currWord = q.poll();
                if (currWord.equals(endWord) ) return res;

                for (int j =0; j < currWord.length(); j++){
                    for (int k = 'a'; k <= 'z'; k++) {
                        char[] arr = currWord.toCharArray();
                        arr[j] = (char) k;
                        String str = new String(arr);

                        if (set.contains(str) && !visited.contains(str)) {
                            q.add(str);
                            visited.add(str);
                        }

                    }
                }

            }
            res++;

        }
        return 0;

    }
}
