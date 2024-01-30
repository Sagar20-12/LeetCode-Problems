import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int inp = stack.pop();
                int out = stack.pop();
                if(tokens[i].equals("+"))
                    stack.push(out + inp);
                else if(tokens[i].equals("-"))
                    stack.push(out - inp);
                else if(tokens[i].equals("*"))
                    stack.push(out * inp);
                else if(tokens[i].equals("/"))
                    stack.push(out / inp);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }
}
