import java.util.*;

public class TopoDFS {
    static HashMap<Integer, List<Integer>> adj;
    static Stack<Integer> topo;
    static boolean[] vis;
    // Directed acyclic graph only
    // Assume the input is correct. Do not bother about detecting cycles
    public static void main(String[] args) {
        int[][] edges = {{6,1},{5,1},{6,3},{3,4},{4,2},{5,2}};
        int n = 6;
        adj = new HashMap<>();
        vis = new boolean[n+1];

        for(int[] e: edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
        }

        topo = new Stack<>();

        for(int i = 1; i <= n ; i++) {
            if(!vis[i]) {
                dfsTopo(i);
            }
        }

        while(!topo.isEmpty()) {
            System.out.print(topo.pop() + " ");
        }
    }

    public static void dfsTopo(int node) {
        vis[node] = true;
        List<Integer> lis = adj.get(node);
        if(lis != null) {
            for(int i: lis) {
                if(!vis[i]) {
                    dfsTopo(i);
                }
            }
        }
        topo.add(node);
    }
}
