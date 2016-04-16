/**
 * Created by GGM on 2016/4/16.
 * 链表节点，可以存储任意类型
 */
public class Node<T> {

    T value;

    Node<T> next;

    public Node(T _value){
        this.value = _value;
    }
}
