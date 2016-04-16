import java.util.ArrayList;

/**
 * Created by GGM on 2016/4/16.
 * 栈集合实现的栈
 */
public class SetOfStacks2<T> {

    private final int STACK_SIZE; //每个栈的大小
    private ArrayList<Stack<T>> stacks = new ArrayList<>();  //栈集合

    public SetOfStacks2() {
        this(10);
    }

    public SetOfStacks2(int _stack_size) {
        STACK_SIZE = _stack_size;
    }

    /**
     * 栈的判空
     * @return 栈是否为空
     */
    public boolean isEmpty(){
        return stacks.size() <= 0;
    }

    /**
     * 入栈操作
     * @param value 需要入栈的值
     * @return 返回入栈是否成功
     */
    public boolean push(T value){
        //如果栈集合中没有栈或者上一个栈已经满了，则新建一个栈
        if (stacks.size() == 0 || stacks.get(stacks.size() - 1).isFull()){
            Stack<T> stack = new Stack<>(STACK_SIZE);
            return stack.push(value);
        }else {
            return stacks.get(stacks.size() - 1).push(value);
        }
    }

    /**
     * 出栈操作
     * @return 返回出栈的值
     */
    public T pop(){
        T val = stacks.get(stacks.size() - 1).pop();
        //当最后一个栈的元素数量为0时，则将其移除
        if (stacks.get(stacks.size()-1).isEmpty()) stacks.remove(stacks.size() - 1);
        return val;
    }
}
