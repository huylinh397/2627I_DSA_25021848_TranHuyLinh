public class Queue_<T> {
    private class Node {
        public T item;
        public Node next;
    }

    private Node first = null;
    private Node last = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T target) {
        Node oldLast = last;
        last = new Node();
        last.item = target;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null; // Tránh tình trạng last vẫn trỏ đến node cũ khi Queue rỗng
        }
        return item;
    }
}