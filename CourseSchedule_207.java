import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //construct graph
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0 ; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }

        //indegree
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

//        int[] res = new int[numCourses];
        int count = 0;

        //BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i =0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.remove();
//            res[count] = curr;
//            count++;

            for (int next: graph[curr]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
