class MyQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) transfer();
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) transfer();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void transfer() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
}
