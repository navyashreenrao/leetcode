import java.util.*;

public class BiparBFS {
    // Undirected graph
    public static void main(String[] args) {
        int[][] edges = {{7,2},{2,3},{3,4},{4,5},{5,6},{2,6},{8,5}};
        if(bfsCol(8, edges)) {
            System.out.println("Is bipartite!");
        } else {
            System.out.println("Not bipartite");
        }
    }

    private static boolean bfsCol(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] e: edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] colours = new int[n + 1];
        Arrays.fill(colours, -1);

        for(int i = 1; i <= n; i++) {
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            if(colours[i] == -1) {
                colours[i] = 1;
            }
            List<Integer> lis = adj.get(i);
            if(lis != null) {
                for(int l: lis) {
                    if(colours[l] == -1) {
                        colours[l] = 1 - colours[i];
                        q.add(l);
                    } else {
                        if(colours[l] == colours[i]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
