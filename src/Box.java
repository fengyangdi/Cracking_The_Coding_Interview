import java.util.HashMap;
import java.util.LinkedList;

public class Box {
    public int getHeight(int[] w, int[] l, int[] h, int n) {
        if (w == null || l == null || h == null ||
                w.length <= 0 || l.length <= 0 || h.length <= 0 || n <= 0){
            return 0;
        }
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();

        LinkedList<Integer> hasBeenPut = new LinkedList<>();

        LinkedList<Integer> stack = pushBox(w, l, h, n, map, -1, hasBeenPut);

        int maxHight = 0;

        for (int i : stack) {
            maxHight += h[i];
        }

        return maxHight;
    }

    private LinkedList<Integer> pushBox(int[] w, int[] l, int[] h, int n, HashMap<Integer, LinkedList<Integer>> map,
                                        int index, LinkedList<Integer> hasBeenPut) {
        if ( index < n && map.containsKey(index)) return (LinkedList<Integer>) map.get(index).clone();
        LinkedList<Integer> max_stack = null;
        int maxHeight = -1;
        for (int i =  0; i < n; i++){
            if (canBeBottom(w, l, h, hasBeenPut, i, index)){
                hasBeenPut.add(i);
                LinkedList<Integer> new_stack = pushBox(w, l, h, n, map, i, hasBeenPut);
                hasBeenPut.remove((Integer) i);
                int high = getHeightInStack(h, new_stack);
                if (max_stack == null || high > maxHeight){
                    max_stack = new_stack;
                    maxHeight = high;
                }
            }
        }
        if (max_stack == null)
        {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(index);
            map.put(index, list);
            return (LinkedList<Integer>) list.clone();
        }
        if (index != -1)
            max_stack.addFirst(index);

        map.put(index, max_stack);
        return (LinkedList<Integer>) max_stack.clone();
    }

    private int getHeightInStack(int[] h, LinkedList<Integer> new_stack) {
        int count = 0;
        for (Integer i : new_stack) {
            count += h[i];
        }
        return count;
    }

    private boolean canBeBottom(int[] w, int[] l, int[] h, LinkedList<Integer> hasBeenPut, int i, int lastIndex) {
        if (lastIndex == -1) return true;
        if (hasBeenPut.contains(i)) return false;
        if (w[lastIndex] <= w[i] || l[lastIndex] <= l[i]){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        /*int[] w = {1,2,3,4,5};
        int[] l = {2,3,4,5,6};
        int[] h = {3,4,5,6,7};
        int n = 5;*/

        int[] w = {2768,542,832,844,2920,587,72,1724,447,809,672,2393,1235,2775,273,1165,1809,111,1263,2751,1068,2507,453,65,2338,1103,1093,2327,1995,1125,2340,1133,2123,1692,2215,140,1822,2144,2240,2916,1860,2226,698,846,2177,295};
        int[] l = {821,2593,1581,2891,2853,1662,2747,2856,2178,865,383,523,809,998,312,237,1871,2730,823,676,568,1839,2063,1651,2704,2113,1316,2892,1874,270,1112,869,1099,1876,371,2298,2070,1514,2916,165,1043,1355,2852,1319,1979,1961};
        int[] h = {771,2963,1599,1910,2317,2884,872,2463,949,341,2718,1500,1071,539,2463,1355,104,2989,1240,240,981,0,2172,3011,621,681,1178,2518,2766,615,460,2399,2443,2894,799,1726,2454,2099,2279,2911,2018,426,2896,224,2663,351};
        int n = 46;

        System.out.println(new Box().getHeight(w, l, h, n));
    }

}