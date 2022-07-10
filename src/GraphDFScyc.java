import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GraphDFScyc {
    // Undirected graph
    static HashMap<Integer, List<Integer>> adj;
    static boolean[] vis;
    public static boolean dfsCyc(int node, int parent) {
        List<Integer> lis = adj.get(node);
        vis[node] = true;
        if(lis != null) {
            for(int i: lis) {
                if(!vis[i]) {
                    if(dfsCyc(i, node)) {
                        return true;
                    }
                } else {
                    // undirected so adjacent
                    if(i != parent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,3},{3,4},{2,5},{5,6},{6,7},{7,5},{7,8}};

        adj = new HashMap<>();
        for(int[] e: edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        vis = new boolean[8 + 1];

        for(int i = 1; i <= 8; i++) {
            if(!vis[i]) {
                if(dfsCyc(i, -1)) {
                    System.out.printf("Contains cycle");
                    return;
                } else {
                    System.out.printf("No cycle");
                }
            }
        }
    }
}
