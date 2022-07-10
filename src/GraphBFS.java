import java.util.*;

public class GraphBFS {
    // Undirected graph
    public static List<Integer> bfs(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] e: edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        List<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            if (!vis[i]) {
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                vis[i] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    bfs.add(node);

                    List<Integer> lis = adj.get(node);
                    if (lis != null) {
                        for (int l : lis) {
                            if (!vis[l]) {
                                vis[l] = true;
                                q.add(l);
                            }
                        }
                    }
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2},{2, 3},{3, 5}, {5, 7}, {7,2}, {4,6}};
        List<Integer> lis = bfs(7, edges);
        for(int l : lis) {
            System.out.print(l);
        }
    }
}
