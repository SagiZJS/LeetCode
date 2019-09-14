package medium;

import java.util.ArrayList;
import java.util.List;

public class _207_CourseSchedule {
    class GraphNode {
        int color;
        int val;
        List<GraphNode> neighbors = new ArrayList<>();
        public GraphNode(int val) {
            super();
            this.val = val;
        }
        
        public void add(GraphNode neighbor) {
            neighbors.add(neighbor);
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        GraphNode[] nodes = new GraphNode[numCourses];
        for (int[] is : prerequisites) {
            GraphNode src = nodes[is[1]];
            GraphNode dst = nodes[is[0]];
            if (dst == null) {
                dst = new GraphNode(is[0]);
                nodes[is[0]] = dst;
            }
            if (src == null) {
                src = new GraphNode(is[1]);
                nodes[is[1]] = src;
            }
            src.add(dst);
        }
        
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && nodes[i].color == 0) {
                if (DFS(nodes[i])) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean DFS(GraphNode node) {
        if (node.color == 1) {
            return true;
        }
        else {
            node.color = 1;
            for (GraphNode neighbor : node.neighbors) {
                if (DFS(neighbor)) {
                    return true;
                }
            }
            node.color = 2;
        }
        return false;
    }
    
    public static void main(String[] args) {
        _207_CourseSchedule s = new _207_CourseSchedule();
        System.out.println(s.canFinish(8, new int[][] {{1,0},{0,1}}));
    }
}
