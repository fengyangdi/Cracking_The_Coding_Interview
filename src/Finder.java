import java.util.*;

/**
 * 数组A包含了0到n的所有整数，但其中缺失了一个。对于这个问题，我们设定限制，使得一次操作无法取得数组number里某个整数的完整内容。
 * 唯一的可用操作是询问数组中第i个元素的二进制的第j位(最低位为第0位)，该操作的时间复杂度为常数，请设计算法，在O(n)的时间内找到这个数。
 给定一个数组number，即所有剩下的数按从小到大排列的二进制各位的值，
 如A[0][1]表示剩下的第二个数二进制从低到高的第二位。同时给定一个int n，意义如题。请返回缺失的数。
 测试样例：
 [[0],[0,1]]
 返回：1
 */

public class Finder {
    public int findMissing(int[][] numbers, int n) {
        int result = 0;
        int index = 0;
        boolean isBreak = false;
        for(int i = 0; i < n - 1; i++){
            if (numbers[i][0] == numbers[i+1][0]){
                //奇数和偶数最低位不同，中间缺数，则相邻的数同为奇数或者偶数，则最低位相同
                index = i;
                isBreak = true;
                break;
            }
        }
        if (!isBreak) index = n - 1;
        int adder = 1; //进位
        for (int i = 0; i < numbers[index].length; i++){
            if (numbers[index][i] + adder == 2){
                adder = 1;
                continue;
            }
            if (numbers[index][i] + adder != 0){
                result += (int) Math.pow(2,i);
            }
            adder = 0;
        }
        if (adder != 0) result += (int) Math.pow(2,numbers[index].length);
        return  result;
    }
}