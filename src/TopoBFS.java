import java.util.*;

public class TopoBFS {
    static HashMap<Integer, List<Integer>> adj;
    static int[] topo;
    static boolean[] vis;
    static int[] inDeg;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) {
        int[][] edges = {{6,1},{5,1},{6,3},{3,4},{4,2},{5,2}};
        int n = 6;
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

        topo = new int[n];
        int index = 0;
        zeroInd();

        while(!q.isEmpty()) {
            int node = q.poll();
            topo[index++] = node;
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

        for(int i = 0; i < topo.length; i++) {
            System.out.print(topo[i] + " ");
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
