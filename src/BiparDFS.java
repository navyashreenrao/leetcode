import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BiparDFS {
    static HashMap<Integer, List<Integer>> adj;
    static int[] colours;
    // Undirected graph
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{4,5},{5,6},{2,7},{7,6},{8,5}};
        int n = 8;

        adj = new HashMap<>();
        for(int[] e: edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        colours = new int[n + 1];
        Arrays.fill(colours, -1);

        for(int i = 1; i <= n; i++) {
            if(colours[i] == -1) {
                colours[i] = 1;
                if(!dfsCol(i)) {
                    System.out.printf("Not bipar");
                    return;
                }
            }
        }
        System.out.printf("Is bipartite");
    }
    private static boolean dfsCol(int i) {
        List<Integer> lis = adj.get(i);
        if(lis != null) {
            for(int l : lis) {
                if(colours[l] == -1) {
                    colours[l] = 1 - colours[i];
                    if(!dfsCol(l)){
                        return false;
                    }
                } else {
                    if(colours[l] == colours[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
