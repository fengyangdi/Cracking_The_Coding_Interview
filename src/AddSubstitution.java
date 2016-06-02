import java.util.*;

public class AddSubstitution {
    public int calc(int a, int b, int type) {
        int re = 0;
        switch(type){
            case 1: re = calcMulti(a,b);break;
            case 0: re = calcDiv(a,b);break;
            case -1: re = calcDecr(a,b);break;
        }
        return re;
    }

    public int calcMulti(int a, int b){
        if(a ==0 || b ==0) return 0;
        int re = 0;
        //int size;
        int absa = Math.abs(a);
        int absb = Math.abs(b);
        if(absa > absa) {
            int t = absa;
            absa = absb;
            absb = t;
        }

        for(int i = 0; i < a; i++){
            re += absb;
        }
        if((a<0 && b <0) || (a>0 && b>0)) return re;
        return negative(re);
    }

    public int calcDiv(int a, int b){
        int re = 0;
        //int size;
        int absa = Math.abs(a);
        int absb = Math.abs(b);
        int sum = absb;
        while(absa >= sum){
            re ++;
            sum += absb;
        }
        //if(a == sum) re++;
        if((a<0 && b <0) || (a>0 && b>0)) return re;

        return negative(re);
    }

    public int calcDecr(int a, int b){
        int re = 0;
        boolean asb = false;
        if(a < b){
            int t = a;
            a = b;
            b = t;
            asb = true;
        }
        for(int i = b; i < a; i++){
            re ++;
        }
        if(asb) return negative(re);
        return re;
    }

    public int negative(int re){
        return -re;
    }
}