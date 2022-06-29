import java.util.HashMap;

public class LC3_LongestSub {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0;
        int count = 0;
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(hm.containsKey(ch)) {
                i = hm.get(ch) + 1;
                hm.clear();
                max = Math.max(max, count);
                count = 0;
            } else {
                hm.put(ch, i);
                count++;
                i++;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
