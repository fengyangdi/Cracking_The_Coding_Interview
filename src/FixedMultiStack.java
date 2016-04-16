/**
 * Created by GGM on 2016/4/16.
 * 拥有多个固定大小的栈的类型，多个栈的大小一致
 * 栈可以存储任意类型
 */
public class FixedMultiStack<T> {

    private final int stackSize; //栈的容量

    private final int stackNum; //栈的数量

    private T[] buffer; //存放数据的数组

    private int[] stackPointer; //每个栈的栈顶指针

    /**
     * 默认构造器，指定默认栈容量(100)和栈的数量(3)
     * 初始化保存数据的数组以及每个栈的栈顶指针(每一个栈初始指针均为-1)
     */
    public FixedMultiStack(){
        this(100, 3);
    }

    /**
     * 构造器，指定栈容量和栈的数量（栈容量和栈的数量需要控制在一定范围）
     * 初始化保存数据的数组以及每个栈的栈顶指针(每一个栈初始指针均为-1)
     */
    public FixedMultiStack(int _stackSize, int _stackNum){
        this.stackSize = _stackSize;
        this.stackNum = _stackNum;
        this.buffer = (T[])new Object[stackSize*stackNum];
        this.stackPointer = new int[stackNum];
        initPointer(stackPointer);
    }

    /**
     * 初始化每个栈的栈顶指针
     * @param stackPointer 栈顶指针数组
     */
    private void initPointer(int[] stackPointer) {
        for (int i = 0; i < stackPointer.length; i++){
            stackPointer[i] = -1;
        }
    }

    /**
     * 讲数据存放到第stackNum个栈中，stackNum从1开始计数
     * @param stackNum 第stackNum个栈
     * @param value 放入栈的值
     * @throws Exception 当栈号不正确时或者栈满时，抛出异常
     */
    public void push(int stackNum, T value) throws Exception{
        //检查栈的编号是否正确
        if(stackNum <= 0 || stackNum > this.stackNum)
            throw new Exception("The stackNum is not in the correct range [1," + this.stackNum + "].");
        // 检查栈中是否还有空间存储数据
        if (stackPointer[stackNum-1] + 1 >= stackSize){
            throw new Exception("The stack " + stackNum + " is full.");
        }
        //修改栈顶指针
        stackPointer[stackNum - 1]++;
        //输入数据入栈
        buffer[getRealIndex(stackNum)] = value;
    }

    /**
     * 第stackNum个栈的出栈操作
     * @param stackNum 第stackNum个栈，从1开始计数
     * @return 返回相应栈的栈顶元素
     * @throws Exception 当栈顶元素不存在时抛出异常
     */
    public T pop(int stackNum) throws Exception{
        //当栈为空时，抛出异常
        if(stackPointer[stackNum - 1] < 0)
            throw  new Exception("The stack "+ stackNum + " is empty.");
        T result = (T)buffer[getRealIndex(stackNum)];
        //清除原来的数据
        buffer[getRealIndex(stackNum)] = null;
        //修改栈顶指针
        stackPointer[stackNum - 1]-- ;
        return result;
    }

    /**
     * 获得第stackNum个栈的栈顶元素
     * @param stackNum 第stackNum个栈，从1开始计数
     * @return 返回相应栈的栈顶元素
     * @throws Exception 当栈顶元素不存在时抛出异常
     */
    public T peek(int stackNum) throws Exception{
        //当栈为空时，抛出异常
        if(stackPointer[stackNum - 1] < 0)
            throw  new Exception("The stack "+ stackNum + " is empty.");
        T result = (T)buffer[getRealIndex(stackNum)];
        return result;
    }

    /**
     * 判断第stackNum个栈是否为空
     * @param stackNum 第stackNum个栈，从1开始计算
     * @return 返回相应的栈是否为空
     */
    public boolean isEmpty(int stackNum){
        return stackPointer[stackNum - 1] < 0;
    }

    /**
     * 获得当前栈的栈顶指针在数组中的真正位置
     * @param stackNum 第stackNum个栈，从1开始计算
     * @return 返回真正的栈顶指针
     */
    private int getRealIndex(int stackNum) {
        return (stackNum - 1) * this.stackSize + stackPointer[stackNum - 1];
    }

   /* public static void main(String[] args) {
        FixedMultiStack<Integer> stack = new FixedMultiStack<>(3,1);
        try {
            stack.push(1,1);
            int a = stack.peek(1);
            System.out.println(stack.isEmpty(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
