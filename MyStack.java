public class MyStack {
    private Object[] stack;
    private int top;

    public MyStack() {
        stack = new Object[10];
        top = -1;
    }

    public void push(Object value) {
        if (top == stack.length - 1) {
            resizeArray();
        }

        top++;
        stack[top] = value;
    }

    public void remove(int index) {
        if (index >= 0 && index <= top) {
            for (int i = index; i < top; i++) {
                stack[i] = stack[i + 1];
            }

            stack[top] = null;
            top--;
        }
    }

    public void clear() {
        stack = new Object[10];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public Object peek() {
        if (top == -1) {
            return null;
        }

        return stack[top];
    }

    public Object pop() {
        if (top == -1) {
            return null;
        }
        Object value = stack[top];
        stack[top] = null;
        top--;
        return value;
    }

    private void resizeArray() {
        Object[] newStack = new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
