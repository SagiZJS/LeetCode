package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1192_CriticalConnectionsinaNetwork {
    private int depth = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] d = new int[n];
        int[] l = new int[n];
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        for (int i =0 ; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> p : connections) {
            int u = p.get(0);
            int v = p.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i <n ;i ++) {
            if (d[i] == 0) {
                dfs(i,-1,ret,graph,d,l);
            }
        }
        
        return ret;
    }
    
    void dfs(int u, int parent, List<List<Integer>> ret, List<Integer>[] graph, int[] d, int[] l) {
        depth++;
        d[u] = depth;
        l[u] = depth;
        List<Integer> children = graph[u];
        for (int v : children) {
            if (v == parent) {
                continue;
            } else {
                if (d[v] == 0) {
                    dfs(v,u,ret,graph,d,l);
                    l[u] = Math.min(l[u], l[v]);
                    if (d[u] < l[v]) {
                        ret.add(Arrays.asList(u, v));
                    }
                } else {
                    l[u] = Math.min(l[u], l[v]);
                }
            }
        }
        
    }
}
