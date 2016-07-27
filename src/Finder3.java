/**
 * Created by 46392_000 on 2016/7/7.
 */
public class Finder3 {
    public int findString(String[] str, int n, String x) {
        if (str == null || str.length <= 0 || n <= 0 || x == null) return -1;

        int left = 0;
        int right = n - 1;

        int result = findBinary(str, left, right, x);

        return result;
    }

    private int findBinary(String[] str, int left, int right, String x) {
        if (left > right) return -1;

        int mid = (left + right) / 2;

        if (str[mid].equals(x)) return mid;

        if ("".equals(str[mid])){ //找到最近的一个非""字符串
            int lIndex = mid - 1;
            int rIndex = mid + 1;
            boolean isFind = false;
            while (lIndex >= left && rIndex <= right && !isFind){
                if (!"".equals(str[rIndex])){
                    if (x.equals(str[rIndex])) return rIndex;
                    isFind = true;
                    String tmp = str[rIndex];
                    str[rIndex] = str[mid];
                    str[mid] = tmp;
                    break;
                }
                if (!"".equals(str[lIndex])){
                    if (x.equals(str[lIndex])) return lIndex;
                    isFind = true;
                    String tmp = str[lIndex];
                    str[lIndex] = str[mid];
                    str[mid] = tmp;
                    break;
                }
                lIndex --;
                rIndex ++;
            }

            while (rIndex <= right && !isFind){
                if (!"".equals(str[rIndex])){
                    if (x.equals(str[rIndex])) return rIndex;
                    isFind = true;
                    String tmp = str[rIndex];
                    str[rIndex] = str[mid];
                    str[mid] = tmp;
                    break;
                }
                rIndex ++;
            }

            while (lIndex >= left && !isFind){
                if (x.equals(str[lIndex])) return lIndex;
                if (!"".equals(str[lIndex])){
                    isFind = true;
                    String tmp = str[lIndex];
                    str[lIndex] = str[mid];
                    str[mid] = tmp;
                    break;
                }
                lIndex --;
            }

        }

        if (str[mid].equals(x)) return mid;
        else if (str[mid].compareTo(x) < 0){
            return findBinary(str, mid + 1, right, x);
        }else {
            return findBinary(str, left, mid - 1, x);
        }

    }
}