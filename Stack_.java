public class Stack_ <T>  {
    class Node{
        public Node next;
        public T item;
    }
    private Node first = null;

    public void push(T target){
            Node newNode = new Node();
            newNode.item = target;
            newNode.next = first;
            first = newNode;
    }
    public T pop(){
        if (first == null){
            return null;
        }
        Node tmp = first;
        first = first.next;
        return tmp.item;
    }
}
