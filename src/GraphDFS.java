import java.util.*;

public class GraphDFS {
    // Undirected graph
    static HashMap<Integer, List<Integer>> adj;
    static List<Integer> dfsRes;
    static boolean[] vis;
    public static void dfs(int node) {
        List<Integer> lis = adj.get(node);
        vis[node] = true;
        dfsRes.add(node);
        if(lis != null) {
            for(int i: lis) {
                if(!vis[i]) {
                    dfs(i);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2},{2, 3},{3, 5}, {5, 7}, {7,2}, {4,6}};

        adj = new HashMap<>();
        for(int[] e: edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        dfsRes = new ArrayList<>();
        vis = new boolean[7 + 1];

        for(int i = 1; i <= 7; i++) {
            if(!vis[i]) {
                dfs(i);
            }
        }

        for(int i : dfsRes) {
            System.out.print(i);
        }
    }
}
