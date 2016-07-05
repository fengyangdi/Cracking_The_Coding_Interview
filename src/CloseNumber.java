public class CloseNumber {
    public int[] getCloseNumber(int x) {
        int sm = 0 ,bg = 0;
        boolean sC = false, bC = false;
        int a = 1;
        for(int i = 1; i < 31; i++){
            a = 1;
            a <<= i;
            if((a & x) == 0){
                if(!sC && ((a << 1) & x) != 0){
                    sm = x - (a>>1);
                	sC = true;
                }
                if(!sC) a>>=1;
                if(!bC && ((a >> 1) & x) != 0){
                    bg = x + a;
                    bC = true;
                }
            }
            if(sC && bC) break;
        }
        return new int[]{sm, bg};
    }
}