import java.util.Iterator;

/**
 * Created by GGM on 2016/3/30.
 * 自定义链栈，带头节点
 */
public class LinkedStack<T> implements Iterable<T>{
    private static class Node<T>{

        T item;
        Node<T> next;
       public Node(T value){
           this.item = value;
       }

    }
    private Node<T> head = new Node<>(null);

    public void push(T value){
        Node<T> node = new Node(value);
        node.next = head.next;
        head.next = node;
    }

    public T pop(){
        if (head.next == null) return null;
        Node<T> p = head.next;
        head.next = head.next.next;
        return p.item;
    }

    public T peek() {
        if (head.next == null) return null;
        Node<T> p = head.next;
        return p.item;
    }

    public boolean isEmpty(){
        return head.next == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else {
            String result = "[";
            Node<T> p = head.next;
            while (p!=null){
                result += p.item+",";
                p = p.next;
            }
            result = result.substring(0,result.length()-1);
            return result+"]";
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current.next == null ? false : true;
            }

            @Override
            public T next() {
                current = current.next;
                return current.item;
            }
        };
    }

}
