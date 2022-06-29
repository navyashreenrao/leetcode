import java.util.Stack;

public class LC150_RevPolNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            if(isOp(tokens[i])) {
                st.push(performOp(tokens[i], st.pop(), st.pop()));
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
    private boolean isOp(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    private int performOp(String s, int a, int b) {
        switch(s) {
            // Order of exec important
            case "+" : return a + b;
            case "-" : return b - a;
            case "*" : return a * b;
            case "/" : return b / a;
        }
        return 0;
    }
}
