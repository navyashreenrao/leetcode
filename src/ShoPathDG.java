import java.util.*;

public class ShoPathDG {
    // Shortest path, directed graph with unit weights
    // Topo sort into stack, pick from stack
    static HashMap<Integer, List<int[]>> adj;
    static Stack<Integer> topo;
    static boolean[] vis;
    // Directed acyclic graph only
    // Assume the input is correct. Do not bother about detecting cycles
    public static void main(String[] args) {
        int[][] edges = {{1,2,1},{1,4,4},{1,5,5},{2,3,1},{3,4,1},{3,6,3},{6,5,1}};
        int n = 6;
        adj = new HashMap<>();
        vis = new boolean[n+1];

        for(int[] e: edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }

        topo = new Stack<>();

        for(int i = 1; i <= n ; i++) {
            if(!vis[i]) {
                dfsTopo(i);
            }
        }

//        System.out.println("Toposort");
//        while(!topo.isEmpty()) {
//            System.out.print(topo.pop() + " ");
//        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        // First index
        dis[1] = 0;

        while(!topo.isEmpty()) {
            int node = topo.pop();
            if(dis[node] != Integer.MAX_VALUE) {
                List<int[]> lis = adj.get(node);
                if(lis != null) {
                    for(int[] l: lis) {
                        dis[l[0]] = Math.min(dis[l[0]], dis[node] + l[1]);
                    }
                }
            }
        }

        System.out.println("Distance");
        for(int i = 1; i < dis.length; i++) {
            System.out.printf(dis[i] + "  ");
        }
    }

    public static void dfsTopo(int node) {
        vis[node] = true;
        List<int[]> lis = adj.get(node);
        if(lis != null) {
            for(int[] i: lis) {
                if(!vis[i[0]]) {
                    dfsTopo(i[0]);
                }
            }
        }
        topo.add(node);
    }
}
