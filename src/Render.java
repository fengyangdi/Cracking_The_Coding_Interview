import java.util.*;

public class Render {
    public int[] renderPixel(int[] screen, int x, int y) {
        int nx = x / 8, nxis = x % 8; //nx 位于第几个，nxis该整数中第几个像素
        int ny = y / 8, nyis = y % 8;
        if (nx == ny){
            //位于同一整数时，则从nxis到nxiy位为1,将nxis与nxiy为1的数与当前值做或运算
            screen[nx] |= (int)Math.pow(2, nyis+1) - (int)Math.pow(2, nxis) ;
            return screen;
        }
        //需要判断开始和结尾两个数的位置，中间的其余数是完整的情况，则中间的数变成255
        //首先判断开头
        //第nx个整数不一定全部为1，从nxis 到 7 位为 1, 0 到 nxis - 1 位为0
        screen[nx] |= 255 - (int)Math.pow(2, nxis) + 1;
        //ny类似，第ny个整数的， 0 到 nxiy位为1
        screen[ny] |= (int)Math.pow(2, nyis+1) - 1;
        //nx 到 ny中间的整数均为255
        for (int i = nx + 1; i < ny; i++){
            screen[i] = 255;
        }
        return screen;
    }
}