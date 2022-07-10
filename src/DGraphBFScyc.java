import java.util.*;

public class DGraphBFScyc {
    static HashMap<Integer, List<Integer>> adj;
    static List<Integer> topo;
    static boolean[] vis;
    static int[] inDeg;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) {
        // int[][] edges = {{6,1},{5,1},{6,3},{3,4},{4,2},{5,2}};
        int[][] edges = {{1,2},{2,3},{3,4},{4,5},{6,5},{3,6},{7,2},{7,8},{8,9},{9,7}};
        int n = 9;
        adj = new HashMap<>();
        vis = new boolean[n+1];

        // BFS algo
        inDeg = new int[n + 1];
        inDeg[0]= -1;

        for(int[] e: edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            inDeg[e[1]]++;
        }

//        System.out.println("In degrees");
//        for(int i = 0; i < inDeg.length; i++) {
//            System.out.println(i + " :" + inDeg[i]);
//        }

        topo = new ArrayList<>();
        zeroInd();

        while(!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            List<Integer> lis = adj.get(node);
            if(lis != null) {
                for(int l: lis) {
                    inDeg[l]--;
                    if(inDeg[l] == 0) {
                        q.add(l);
                    }
                }
            }
        }

//        for(int i = 0; i < topo.length; i++) {
//            System.out.print(topo[i] + " ");
//        }
        if(topo.size() == n) {
            System.out.printf("No cycle");
        } else {
            System.out.printf("Cycle detected!");
        }

    }

    private static void zeroInd() {
        for(int i = 0; i < inDeg.length; i++) {
            if(inDeg[i] == 0) {
                inDeg[i] = -1;
                q.add(i);
            }
        }
    }
}
