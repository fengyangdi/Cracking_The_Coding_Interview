/**
 * Created by GGM on 2016/4/17.
 * 两个栈实现的队列
 */
public class StackQueue<T> {
    LinkedStack<T> stack1 = new LinkedStack<>();
    LinkedStack<T> stack2 = new LinkedStack<>();

    /**
     * 判空操作
     * @return
     */
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    /**
     * 入队操作，入队时，进stack1
     * @param value
     */
    public void push(T value){
        stack1.push(value);
    }

    /**
     * 出队列操作，当stack2不为空，stack2出栈（stack2存放的是顺序与进入队列的顺序一致），
     * 否则将stack1中的元素依次出栈，然后入栈。
     * @return
     */
    public T pop(){
        if (stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }else if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                T tmp = stack1.pop();
                stack2.push(tmp);
            }
        }
        //当stack2为空时，将stack1中数据转移到stack2中，然后stack2出栈
        return stack2.pop();
    }
}
