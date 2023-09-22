import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //construct graph
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0 ; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        //indegree
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        int[] res = new int[numCourses];
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
            res[count] = curr;
            count++;

            for (int next: graph[curr]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        if (count != numCourses) {
            return new int[] {};
        }

        return res;
    }
}


//class Solution {
//    // 主函数
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        // 建图，和环检测算法相同
//        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
//        // 计算入度，和环检测算法相同
//        int[] indegree = new int[numCourses];
//        for (int[] edge : prerequisites) {
//            int from = edge[1], to = edge[0];
//            indegree[to]++;
//        }
//
//        // 根据入度初始化队列中的节点，和环检测算法相同
//        Queue<Integer> q = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (indegree[i] == 0) {
//                q.offer(i);
//            }
//        }
//
//        // 记录拓扑排序结果
//        int[] res = new int[numCourses];
//        // 记录遍历节点的顺序（索引）
//        int count = 0;
//        // 开始执行 BFS 算法
//        while (!q.isEmpty()) {
//            int cur = q.poll();
//            // 弹出节点的顺序即为拓扑排序结果
//            res[count] = cur;
//            count++;
//            for (int next : graph[cur]) {
//                indegree[next]--;
//                if (indegree[next] == 0) {
//                    q.offer(next);
//                }
//            }
//        }
//
//        if (count != numCourses) {
//            // 存在环，拓扑排序不存在
//            return new int[]{};
//        }
//
//        return res;
//    }
//
//    // 建图函数
//    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
//        // 图中共有 numCourses 个节点
//        List<Integer>[] graph = new LinkedList[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            graph[i] = new LinkedList<>();
//        }
//        for (int[] edge : prerequisites) {
//            int from = edge[1], to = edge[0];
//            // 修完课程 from 才能修课程 to
//            // 在图中添加一条从 from 指向 to 的有向边
//            graph[from].add(to);
//        }
//        return graph;
//    }
//}
//// 详细解析参见：
//// https://labuladong.github.io/article/?qno=210
