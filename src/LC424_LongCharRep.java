import java.util.HashMap;
import java.util.Map;
// Med
public class LC424_LongCharRep {
    public int characterReplacement(String s, int k) {
        // https://www.youtube.com/watch?v=gqXU1UyA8pk
        // Store freq
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while(left < s.length() && right < s.length() && left <= right) {
            hm.put(s.charAt(right), hm.getOrDefault(s.charAt(right), 0) + 1);
            int windowSize = right - left + 1;
            if((windowSize - findMax(hm)) <= k) {
                // Replace possible
                res = Math.max(res, windowSize);
                right++;
            } else {
                // Decrement freq of left
                hm.put(s.charAt(left), hm.getOrDefault(s.charAt(left), 1) - 1);
                left++;
                right++;
            }
        }
        return res;
    }
    private int findMax(HashMap<Character, Integer> hm) {
        int max = 0;
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}
