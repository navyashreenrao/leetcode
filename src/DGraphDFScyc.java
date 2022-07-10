import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DGraphDFScyc {
    static HashMap<Integer, List<Integer>> adj;
    static boolean[] vis;
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{4,5},{6,5},{3,6},{7,2},{7,8},{8,9},{7,9}};
        // int[][] edges = {{1,2},{2,3},{3,4}};
        int n = 9;

        adj = new HashMap<>();
        for(int[] e: edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
        }

        vis = new boolean[n + 1];
        boolean[] dfsvis = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            if(!vis[i]) {
                if(dfsCyc(i, dfsvis)) {
                    System.out.println("Contains cycle");
                    return;
                }
            }
        }
        System.out.println("No cycle!");
    }

    public static boolean dfsCyc(int i, boolean[] dfsvis) {
        vis[i] = true;
        dfsvis[i] = true;

        List<Integer> lis = adj.get(i);
        if(lis != null) {
            for(int l: lis) {
                if(!vis[l]) {
                    if(dfsCyc(l, dfsvis)) {
                        return true;
                    }
                } else if (dfsvis[l]) {
                    return true;
                }
            }
        }
        dfsvis[i] = false;
        return false;
    }
}
