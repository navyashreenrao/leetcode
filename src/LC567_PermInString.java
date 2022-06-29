import java.util.HashMap;
// Medium
public class LC567_PermInString {
    // Better solution mentioned here: https://www.youtube.com/watch?v=UbyhOgBN834
    public boolean checkInclusion(String s1, String s2) {
        int start = 0;

        int l1 = s1.length();
        int l2 = s2.length();

        HashMap<Character, Integer> hm1 = new HashMap<>();
        for(int i = 0; i < l1; i++) {
            char ch = s1.charAt(i);
            hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
        }

        while(start <= (l2 - l1)) {
            String s = s2.substring(start, start + l1);

            HashMap<Character, Integer> hm2 = new HashMap<>();
            for(int i = 0; i < l1; i++) {
                char ch2 = s.charAt(i);
                hm2.put(ch2, hm2.getOrDefault(ch2, 0) + 1);
            }

            if(hm1.equals(hm2)) {
                return true;
            } else {
                start++;
            }
        }
        return false;
    }
}
