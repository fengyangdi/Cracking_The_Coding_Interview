/**
 * Created by GGM on 2016/4/16.
 * 自定义栈的数据结构，有容量的栈
 */
public class Stack<T> {

    private int capacity;  //栈的容量

    private int size = 0; //容量

    private Node<T> top = null; //栈顶元素

    public Stack(int _capacity){
        this.capacity = _capacity;
    }

    /**
     * 判断栈是否为空
     * @return 返回栈是否为空
     */
    public boolean isEmpty(){
        return  this.size == 0;
    }

    /**
     * 判断栈是否已经满了
     * @return 返回栈是否满
     */
    public boolean isFull(){
        return this.size == this.capacity;
    }

    /**
     * 将数据入栈
     * @param value
     * @return 返回入栈操作是否成功
     */
    public boolean push(T value){
        //如果栈满，返回false
        if (this.size >= this.capacity) return false;
        Node<T> node = new Node<>(value);
        //栈是空的情况
        if (this.top == null) this.top = node;
        else {
            node.next = top;
            this.top = node;
        }
        this.size ++;
        return true;
    }

    /**
     * 出栈操作
     * @return 返回出栈的元素
     */
    public T pop(){
        if(this.size <= 0) return null;
        Node<T> node = top;
        top = top.next;
        node.next = null;
        size --;
        return node.value;
    }
}
