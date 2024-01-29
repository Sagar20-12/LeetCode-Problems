class MyQueue {
    // Inititalise two stack input and output 
    Stack<Integer> input;
    Stack<Integer> output;


    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    // pushing the elements in the new input stack
    public void push(int x) {
        input.push(x);
    }
    
    // If pop instruction comes, then check for peek element.
    public int pop() {
        int topElement = peek();
        output.pop();
        return topElement;
    }
    
    // Transferring from input stack to output stack
    public int peek() {
        if(output.empty()){
            while(!input.empty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */