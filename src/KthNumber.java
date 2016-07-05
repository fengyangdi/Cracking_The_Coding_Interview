import java.util.*;

public class KthNumber {
    public int findKth(int k) {
        int val = 0;
        LinkedList<Integer> q3 = new LinkedList<Integer>();
        LinkedList<Integer> q5 = new LinkedList<Integer>();
        LinkedList<Integer> q7 = new LinkedList<Integer>();
        q3.add(3);
        q5.add(5);
        q7.add(7);
        for (int i = 0; i < k; i++){
            int v3 = q3.isEmpty() ? Integer.MAX_VALUE : q3.peek();
            int v5 = q5.isEmpty() ? Integer.MAX_VALUE : q5.peek();
            int v7 = q7.isEmpty() ? Integer.MAX_VALUE : q7.peek();
            val = Math.min(v3,Math.min(v5,v7));
            if (v3 == val){
                q3.remove();
                q3.add(val*3);
                q5.add(val*5);
            }else if (v5 == val){
                q5.remove();
                q5.add(val*5);
            }else {
                q7.remove();
            }
            q7.add(val*7);
        }
        return val;
    }
}