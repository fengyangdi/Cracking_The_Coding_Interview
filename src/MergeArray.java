/**
 * Created by 46392_000 on 2016/7/5.
 */
public class MergeArray {
    public void merge(int[] a, int[] b, int lastA, int lastB){
        int indexA = lastA - 1, indexB = lastB - 1;
        int mergeIndex = lastA + lastB - 1;

        while (indexA >= 0 && indexB >=0){
            if (a[indexA] > b[indexB]){
                a[mergeIndex--] = a[indexA--];
            }else {
                a[mergeIndex--] = b[indexB--];
            }
        }

        //将b中剩余的元素复制到a中
        while (indexB >= 0){
            a[mergeIndex--] = b[indexB--];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 5; i ++){
            a[i] = i*2+1;
        }
        int[] b = {0,2,4,6,8};
        new MergeArray().merge(a,b,5,5);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
