public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private Object value;
        private Node previous;
        private Node next;

        public Node(Object value, Node previous, Node next) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
    }

    public void add(Object value) {
        Node newNode = new Node(value, tail, null);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = getNode(index);

        if (currentNode.previous != null) {
            currentNode.previous.next = currentNode.next;
        } else {
            head = currentNode.next;
        }

        if (currentNode.next != null) {
            currentNode.next.previous = currentNode.previous;
        } else {
            head = currentNode.previous;
        }

        currentNode.previous = null;
        currentNode.next = null;
        currentNode.value = null;
        size--;
    }

    public void clear() {
        Node currentNode = head;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.value = null;
            currentNode.previous = null;
            currentNode.next = null;
            currentNode = nextNode;
        }
        head = null;
        tail = null;
        size = 0;
    }

    private Node getNode(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}
