import java.util.*;

public class Max {
    public int getMax(int a, int b) {
        int fa = (a >> 31 & 0x01) ^ 1;  // a >= 0 fa = 1，否则fa = 0;
        int fb = (b >> 31 & 0x01) ^ 1;
        int fc = ((a-b) >> 31 & 0x01) ^ 1;

        int fa_fb = fa ^ fb;   //如果a和b不同符号，则该值为1，因为可能发生溢出，所以当a和b不同时，使用fa，否则使用fc；
        int use_fc = fa_fb ^ 1;

        int k = fa_fb * fa + fc * use_fc;

        return  a * k + b * (k ^ 1);  //a > b时，k = 1;
    }
}