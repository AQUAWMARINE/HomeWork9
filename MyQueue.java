public class MyQueue {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }

        return head.value;
    }

    public Object poll() {
        if (isEmpty()) {
            return null;
        }

        Object value = head.value;
        head = head.next;
        size--;

        if (isEmpty()) {
            tail = null;
        }

        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

