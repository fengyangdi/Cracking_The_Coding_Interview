public class MagicIndex {
    /**
     * A中没有重复元素
     * @param A
     * @param n
     * @return
     */
    public boolean findMagicIndex1(int[] A, int n) {
        if (A == null || A.length <= 0 || n <= 0) return false;
        int low = 0;
        int high = A.length - 1;

        int mid;

        while (low <= high){
            mid = (low + high) / 2;
            if (mid == A[mid]) return true;
            else if (mid < A[mid]) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }

    /**
     * A中没有重复元素
     * @param A
     * @param n
     * @return
     */
    public boolean findMagicIndex(int[] A, int n) {
        if (A == null || A.length <= 0 || n <= 0) return false;
        int low = 0;
        int high = A.length - 1;

        return findPartly(A, low, high);
    }

    private boolean findPartly(int[] a, int low, int high) {
        if (low > high) return false;
        int mid = (low + high) / 2;
        if (mid == a[mid]) return true;
        //else return findPartly(a, low, mid - 1) || findPartly(a, mid + 1, high);
        //左半部分应该从low 到 min(mid - 1, a[mid])中找
        //同理右半边 max(mid + 1, a[mid]) 到 high中找
        return findPartly(a, low, Math.min(a[mid] , mid - 1)) ||
                findPartly(a, Math.max(mid + 1,a[mid]), high);
    }
}