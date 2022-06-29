import java.util.Stack;

public class LC739_DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        // https://www.youtube.com/watch?v=cTBiBSnjO3c
        // Store indices in the stack
        // Subtract indices for days
        int[] ans = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {
            if(st.isEmpty()) {
                st.push(i);
            } else {
                int curr = temperatures[i];
                while(!st.isEmpty() && curr > temperatures[st.peek()]) {
                    int index = st.pop();
                    ans[index] = i - index;
                }
                st.push(i);
            }
        }
        return ans;
    }
}
