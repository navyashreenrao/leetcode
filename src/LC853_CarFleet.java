import java.util.Arrays;
import java.util.Stack;

// Medium
public class LC853_CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        // https://www.youtube.com/watch?v=Pr6T-3yB9RM
        // Time = dist / speed
        // If a car behind takes lesser time to read than a car in front
        // it means they collide
        int[][] carInfo = new int[speed.length][2];
        for(int i=0; i<speed.length; i++) {
            carInfo[i][0] = position[i];
            carInfo[i][1] = speed[i];
        }
        // Sort based on position only
        Arrays.sort(carInfo, (x, y)->x[0]-y[0]);

        double[] time = new double[speed.length];
        // Calculate the time it will take for a car to reach the target
        for(int i=0; i<speed.length; i++) {
            time[i] =  (double) (target - carInfo[i][0]) / (double) carInfo[i][1];
        }

        Stack<Double> st = new Stack<>();
        int i = (speed.length)-1;
        int fleet = 0;
        while(i>=0) {
            if(st.isEmpty()) {
                fleet++;
            }
            if (st.isEmpty() || st.peek() >= time[i]) {
                st.push(time[i]);
                i--;
            }else{
                while(!st.isEmpty() && st.peek() < time[i]) st.pop();
            }
        }
        return fleet;
    }
}
