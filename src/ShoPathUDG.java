import java.util.*;

public class ShoPathUDG {
    // Shortest path, Undirected graph with unit weights
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,6},{0,3},{3,4},{4,5},{5,6},{1,3},{6,7},{7,8},{6,8}};
        int n = 9;

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] e: edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 1 indexing
        dist[0] = 0;

        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++) {
            if (!vis[i]) {
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                dist[i] = 0;
                vis[i] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    List<Integer> lis = adj.get(node);
                    if (lis != null) {
                        for (int l : lis) {
                            if (!vis[l]) {
                                vis[l] = true;
                                q.add(l);
                                dist[l] = Math.min(dist[l], dist[node] + 1);
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
