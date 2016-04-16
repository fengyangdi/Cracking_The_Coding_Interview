import java.util.*;

/**
 * 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。
 * 给定一个操作序列int[][2] ope(C++为vector<vector<int>>)，每个操作的第一个数代表操作类型，
 * 若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作，后一个数无意义。
 * 请返回一个int[][](C++为vector<vector<int>>)，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 */
public class SetOfStacks {
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        if(ope.length <= 0) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> stack = new ArrayList<ArrayList<Integer>>();
        int index = -1; //栈的栈顶指针
        for (int i = 0; i < ope.length; i++){
            if (ope[i][0] == 1){
                //判断栈为空或者上个栈已经填满，新建一个栈
                if((++index) % size == 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(index%size,ope[i][2]);
                    stack.add(list);
                }else {
                    stack.get(stack.size()-1).add(index%size,ope[i][2]);
                }
            } else {
                //出栈
                stack.get(stack.size()-1).remove(index%size);
                index--;
                //最后的栈为空时，删除该栈
                if (stack.get(stack.size()-1).size() == 0) stack.remove(stack.size()-1);
            }
        }
        return stack;
    }
}