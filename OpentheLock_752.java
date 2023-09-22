import java.util.*;

public class OpentheLock_752 {
    public int openLock(String[] deadends, String target) {
        if (target == null || target.length()==0) return -1;
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        for (String dead: deadends) {
            deads.add(dead);
        }

        Queue<String> q = new LinkedList<>();
        q.add("0000");
        visited.add("0000");
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i =0; i < size; i++) {
                String curr = q.poll();

                if (deads.contains(curr)) continue;
                if (curr.equals(target)) return level;

                for (String next: getNextLocks(curr)) {
                    if (!visited.contains(next)) {
                        q.add(next);
                        visited.add(next);
                    }
                }

            }
            level++;

        }

        return -1;

    }

    private List<String> getNextLocks(String curr) {
        List<String> locks = new ArrayList<>();
        char[] arr = curr.toCharArray();
        for (int i=0; i<4; i++) {
            char ch = arr[i];
            //up
            if (ch == '9') {
                arr[i] = '0';
            }else {
                arr[i] = (char) (ch +(char)1);
            }

            locks.add(String.valueOf(arr));

            //down
            if (ch == '0') {
                arr[i] = '9';
            }else {
                arr[i] = (char) (ch -(char)1);
            }

            locks.add(String.valueOf(arr));

            arr[i] = ch;
        }

        return locks;
    }

}
