public class Robot {

    /**
     * 没有障碍
     * @param x
     * @param y
     * @return
     */
    public int countWays(int x, int y) {
        if (x <= 0 || y <= 0) return 0;
        int[][] count = new int[x][y];

        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                if (i == 0 || j == 0) count[i][j] = 1;
                else count[i][j] = -1;
            }
        }

        for (int i = 1; i < x; i ++){
            for (int j = 1; j < y; j++){
                count[i][j] = count[i-1][j] + count[i][j-1];
            }
        }

        return count[x-1][y-1];
    }

    /**
     * 没有障碍递归（记录已遍历的点的值）
     * @param x
     * @param y
     * @return
     */
    public int countWays1(int x, int y) {
        if (x <= 0 || y <= 0) return 0;
        int[][] count = new int[x][y];

        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                count[i][j] = -1;
            }
        }

        countWaysRecursion(count, x - 1, y - 1);

        return count[x-1][y-1];
    }

    private int countWaysRecursion(int[][] count, int x, int y) {
        if (x < 0 || y < 0) return 0;
        if (x == 0 && y == 0) return 1;
        if (count[x][y] != -1) return count[x][y];
        return count[x][y] = countWaysRecursion(count, x - 1, y) +
                countWaysRecursion(count, x, y - 1);
    }

    /**
     * 有障碍
     * @param map
     * @param x
     * @param y
     * @return
     */
    public int countWays(int[][] map, int x, int y) {
        if (x <= 0 || y <= 0) return 0;
        int[][] count = new int[x][y];

        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                if (i == 0 && j == 0 && map[i][j] == 1) count[i][j] = 1;
                else if (i == 0 && map[i][j] == 1) count[i][j] = count[i][j-1];
                else if (j == 0 && map[i][j] == 1) count[i][j] = count[i-1][j];
                else count[i][j] = 0;
            }
        }

        for (int i = 1; i < x; i ++){
            for (int j = 1; j < y; j++){
                if (map[i][j] == 1)
                    count[i][j] = count[i-1][j] + count[i][j-1];
                else  count[i][j] = 0;
                count[i][j] %= 1000000007;
            }
        }

        return count[x-1][y-1];
    }
}