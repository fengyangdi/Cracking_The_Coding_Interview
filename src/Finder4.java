/**
 * Created by 46392_000 on 2016/7/7.
 */
public class Finder4 {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        int[] result = {-1,-1};

        if(!(mat == null || mat.length <= 0 || n <=0 || m <= 0)){
            int i = 0, j = m - 1;
            while (i < n && j >= 0){
                if (mat[i][j] == x){
                    result = new int []{i, j};
                    break;
                }else if (mat[i][j] > x) j--;
                else i++;
            }
        }
        return result;
    }
}
