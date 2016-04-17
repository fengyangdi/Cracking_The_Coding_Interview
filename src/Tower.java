/**
 * Created by GGM on 2016/4/17.
 * 汉诺塔问题的塔实体类
 */
public class Tower {
    private LinkedStack<Integer> diskStack;   //存放圆盘的栈
    private int diskNum; //塔的编号

    public int getDiskNum() {
        return diskNum;
    }

    public Tower(int _diskNum){
        this.diskStack = new LinkedStack<>();
        this.diskNum = _diskNum;
    }

    public void add(int value){
        if(!diskStack.isEmpty() && diskStack.peek() < value){
            System.out.println("Error placing the disk " + value);
        }else {
            diskStack.push(value);
        }
    }

    public void moveTOpto(Tower tower){
        int top = diskStack.pop();
        tower.add(top);
        System.out.println("Move disk " + top + " from " + getDiskNum() + " to " + tower.getDiskNum());
    }

    public void moveDisks(int n,Tower destination, Tower buffer){
        if(n > 0){
            moveDisks(n-1,buffer,destination);
            moveTOpto(destination);
            buffer.moveDisks(n-1,destination,this);
        }
    }

    @Override
    public String toString() {
        return diskStack.toString();
    }
}
