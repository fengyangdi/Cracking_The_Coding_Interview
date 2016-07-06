/**
 * Created by 46392_000 on 2016/7/6.
 */

public class Finder2 {
    public int findElement(int[] A, int n, int x) {
        if(A == null || A.length <= 0 || n <= 0) return -1;

        int first = 0;
        int last = A.length - 1;

        int re = findBinary(A, first, last, x);

        return re;
    }

    private int findBinary(int[] a, int first, int last, int val) {

        if (first > last) return -1;

        int mid = (first + last) / 2;

        if (a[mid] == val) return mid;
        if (a[first] < a[mid]){
            //×ó°ë±ßÓĞĞò
            if (a[first] <= val && a[mid] >= val){
                //ÔÚ×ó°ë±ß
                return findBinary(a, first, mid - 1, val);
            }else {
                //ÔÚÓÒ°ë±ß
                return findBinary(a, mid + 1, last, val);
            }
        }else if (a[mid] < a[first]){
            //ÓÒ°ë±ßÓĞĞò
            if (a[mid] <= val && a[last] >= val){
                //ÔÚÓÒ°ë±ß
                return findBinary(a, mid + 1, last, val);
            }else {
                //ÔÚ×ó°ë±ß
                return findBinary(a, first, mid - 1, val);
            }
        }else {
            if (a[mid] != a[last]){
                //ÔÚÓÒ°ë±ß
                return findBinary(a, mid + 1, last, val);
            }else {
                //²»ÄÜÈ·¶¨ÔÚÄÄ±ß
                int result = findBinary(a, first, mid - 1, val);
                if (result != -1){ //ÔÚ×ó°ë±ßÕÒµ½
                    return result;
                }

                return findBinary(a, mid + 1, last, val);
            }
        }

    }

    public static void main(String[] args) {
        int[] a = {63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62};
        System.out.println(new Finder2().findElement(a, a.length, 36));
    }
}
