import java.sql.Array;
import java.util.*;

// Undirected, weighted graph
// Dijkstra's algo
public class ShoPathUDG_Dij {
    static HashMap<Integer, List<int[]>> adj;
    public static void main(String[] args) {
        int[][] edges = {{1,2,10},{1,4,0},{1,5,5},{2,3,1},{3,4,1},{3,6,3},{6,5,1}};
        int n = 6;

        int src = 1;

        adj = new HashMap<>();
        for (int[] e : edges) {
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            List<int[]> lis = adj.get(node[0]);
            if(lis != null) {
                for(int[] l: lis) {
                    if(dis[l[0]] > dis[node[0]] + l[1]) {
                        dis[l[0]] = dis[node[0]] + l[1];
                        pq.add(new int[] {l[0], dis[l[0]]});
                    }
                }
            }
        }

        for(int i = 1; i < dis.length; i++) {
            System.out.printf(dis[i] + " ");
        }
    }
}
