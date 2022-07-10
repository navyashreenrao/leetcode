import java.util.*;

public class GraphBFScyc {
    // Undirected graph
    public static boolean bfsCyc(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] e: edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            if (!vis[i]) {
                Queue<int[]> q = new ArrayDeque<>();
                // Current node and prev node
                q.add(new int[]{i, -1});
                vis[i] = true;

                while (!q.isEmpty()) {
                    int[] node = q.poll();
                    List<Integer> lis = adj.get(node[0]);
                    if (lis != null) {
                        for (int l : lis) {
                            if (!vis[l]) {
                                vis[l] = true;
                                q.add(new int[]{l, node[0]});
                            } else {
                                if(l != node[1]) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2},{2, 4},{3, 5},{5, 6},{6,7},{7,8},{10,9},{5,10},{8,11}};
        if(bfsCyc(11, edges)) {
            System.out.println("Contains cycle!");
        } else {
            System.out.println("No cycle");
        }
    }
}
