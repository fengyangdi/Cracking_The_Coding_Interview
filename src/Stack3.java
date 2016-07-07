import java.util.Arrays;

/**
 * Created by 46392_000 on 2016/7/7.
 */
public class Stack3 {
    public int getHeight(int[][] actors, int n) {

        if (actors == null || actors.length <=0 || n <= 0) return 0;

        arraySortQuick(actors, 0 , actors.length - 1);  //对身高排序

        int[] max = new int[n];
        max[0] = 1;

        getHeight(actors, max, 1);

        Arrays.sort(max);

        return max[n-1];
    }

    private void getHeight(int[][] actors, int[] max, int i) {
        if (i >= actors.length || i < 0) return;

        int maxBefore = 0;

        for(int j = 0; j < i; j ++){
            if (isBefore(actors[j],actors[i]))
                maxBefore = max(maxBefore, max[j]);
        }

        max[i] = maxBefore + 1;

        getHeight(actors, max, i + 1);
    }

    private int max(int maxBefore, int i) {
        return maxBefore > i ? maxBefore : i;
    }

    private boolean isBefore(int[] actor, int[] actor1) {
        if (actor[0] < actor1[0] && actor[1] < actor1[1]){
            return true;
        }
        return false;
    }

    private void arraySortQuick(int[][] arr, int low, int high){
        int poivt = partation(arr, low, high);
        if (poivt > low) arraySortQuick(arr, low, poivt - 1);
        if (poivt < high) arraySortQuick(arr, poivt + 1, high);
    }

    private int partation(int[][] arr, int low, int high) {
        if (low > high) return -1;
        if (low == high) return low;

        int[] tmp = arr[low];

        while (low < high){
            if (low < high && (arr[high][0] > tmp[0] || (arr[high][0] == tmp[0] && arr[high][1] > tmp[1]))){
                high --;
            }

            //交换到low
            if (low < high)
                arr[low] = arr[high];
            //low ++ ;
            if (low < high && (arr[low][0] <= tmp[0] || (arr[low][0] == tmp[0] && arr[low][1] <= tmp[1]))){
                low ++;
            }

            if (low < high)
                arr[high] = arr[low];

            //high --;
        }

        arr[low] = tmp;
        return low;
    }

    public static void main(String[] args) {
        int[][] ac = new int[5][2];
        ac[0][0] = 2;ac[0][1] = 5;
        ac[1][0] = 3;ac[1][1] = 5;
        ac[2][0] = 4;ac[2][1] = 7;
        ac[3][0] = 5;ac[3][1] = 4;
        ac[4][0] = 2;ac[4][1] = 9;
        new Stack3().arraySortQuick(ac, 0 , ac.length - 1);

        for (int[] ints : ac) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
