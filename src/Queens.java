public class Queens {

    private class ReturnObject{
        int count = 0;
    }

    public int nQueens1(int n) {
        if(n <= 0) return 0;
        int[] qRow = new int[n];
        for (int i = 0; i < n; i++){
            qRow[i] = i;
        }
        ReturnObject ro = new ReturnObject();
        findPutWays(qRow, n, 0, ro);
        return ro.count;
    }

    private void findPutWays(int[] qRow, int n, int rowIndex, ReturnObject ro) {
        if (rowIndex == n) {
            if (checkIsOK(qRow)) ro.count++;
            return;
        }
        for (int i = rowIndex; i < n; i++){
            swap(qRow, rowIndex, i);
            findPutWays(qRow, n, rowIndex + 1, ro);
            swap(qRow, rowIndex, i);
        }
    }

    private void swap(int[] qRow, int rowIndex, int i) {
        int tmp = qRow[rowIndex];
        qRow[rowIndex] = qRow[i];
        qRow[i] = tmp;
    }

    private boolean checkIsOK(int[] qRow) {
        for (int i = 0; i < qRow.length - 1; i++){
            for (int j = i + 1; j < qRow.length; i++){
                if (i-j == qRow[i] - qRow[j] || i-j == qRow[j] - qRow[i]) return false;
            }
        }
        return true;
    }

    public int nQueens(int n){
        if (n <= 0) return 0;
        int[] qRow = new int[n+1];  //最后一位保存排法数
        qRow[n] = 0;
        placeQueues(qRow, 0);
        return qRow[n];
    }

    private void placeQueues(int[] qRow, int rowIndex) {
        if (rowIndex == qRow.length - 1) qRow[qRow.length-1] ++;
        else {
            for (int i = 0; i< qRow.length - 1; i++){   //i 设置的列的位置
                if (checkVaild(qRow, rowIndex, i)){
                    qRow[rowIndex] = i;
                    placeQueues(qRow, rowIndex + 1);
                }
            }
        }
    }

    private boolean checkVaild(int[] qRow, int rowIndex, int col) {

        for (int i = 0; i < rowIndex; i++){
            if (qRow[i] == col) return false;
            if (rowIndex - i == col - qRow[i] || rowIndex - i == qRow[i] - col) return false;
        }

        return true;
    }
}