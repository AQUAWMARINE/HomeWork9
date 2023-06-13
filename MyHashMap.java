class MyHashMap {
    private Node[] table;
    private int size;

    private static class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        table = new Node[10];
        size = 0;
    }

    public void put(Object key, Object value) {
        int index = hash(key) % table.length;

        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
            size++;
        } else {
            Node current = table[index];
            Node prev = null;

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }

                prev = current;
                current = current.next;
            }

            prev.next = newNode;
            size++;
        }
    }

    public void remove(Object key) {
        int index = hash(key) % table.length;

        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }

                size--;
                return;
            }

            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        table = new Node[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = hash(key) % table.length;

        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    private int hash(Object key) {
        return key.hashCode();
    }
}
