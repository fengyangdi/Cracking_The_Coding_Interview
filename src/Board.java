public class Board {

    /**
     * N*N的棋盘，求出每一行，每一列的和，对角线的和，判断和是否存在等于N，
     * 存在说明存在一行或者一列或者对角线全部为1，那么就是当前玩家赢了
     * @param board
     * @return
     */
    public boolean checkWon(int[][] board) {

        if (board == null || board.length <= 0
                || board.length != board[0].length) return false;

        int x = 0;
        int y = 0;
        for (int i = 0; i < board.length; i ++){
            int h = 0;
            int s = 0;
            for (int j = 0; j < board.length; j ++){
                h += board[i][j];
                s += board[j][i];
                if (i == j) x += board[i][j];
                if (j == board.length - i - 1) y += board[i][j];
            }
            if (h == board.length || s == board.length) return true;
        }
        if (x == board.length || y == board.length) return true;
        return false;
    }
}

