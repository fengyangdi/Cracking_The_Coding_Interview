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

        //����ÿһ��Ԫ�أ�ʹ֮ÿ��Ԫ�ض��ڵ�һ��λ�ó��֣�ÿ�θ���Ԫ�أ�������ʣ��Ԫ�ؼ�����ͬ���Ĳ���
        for (int j = i; j < array.length; j++){
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;

            getPermutation(array, strs, i+1);

            //������
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

    }
}