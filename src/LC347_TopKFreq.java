import java.util.HashMap;
import java.util.PriorityQueue;

public class LC347_TopKFreq {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: nums) {
            // Get and increment or set to zero
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        // Max heap, so opp subtraction
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));
        for(int i : hm.keySet()) {
            pq.add(i);
        }
        int[] ans = new int[k];
        for(int i = 0; i<k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
