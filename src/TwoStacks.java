import java.util.*;

/**
 * 对栈进行升序排序（最大的元素在栈顶）,ArrayList和数组的0位置为栈顶
 */
public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        int i = 0;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        while(i < numbers.length){
            int tmp = numbers[i];
            while(stack.size() > 0 && tmp < stack.get(0)){
                int re = stack.remove(0);
                numbers[i--] = re;
            }
            stack.add(0,tmp);
            i++;
        }
        return stack;
    }
}