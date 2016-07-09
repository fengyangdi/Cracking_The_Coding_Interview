import java.util.*;

public class Permutation {
    public ArrayList<String> getPermutation(String A) {
        ArrayList<String> strs = new ArrayList<>();
        if (A == null) return strs;
        char[] array = A.toCharArray();
        getPermutation(array, strs, 0);

        Collections.sort(strs, Collections.reverseOrder());

        return strs;
    }

    private void getPermutation(char[] array, ArrayList<String> strs, int i) {
        if (i >= array.length){
            strs.add(new String(array));
            return;
        }

        //交换每一个元素，使之每个元素都在第一个位置出现，每次更换元素，对数组剩余元素继续做同样的操作
        for (int j = i; j < array.length; j++){
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;

            getPermutation(array, strs, i+1);

            //换回来
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

    }
}