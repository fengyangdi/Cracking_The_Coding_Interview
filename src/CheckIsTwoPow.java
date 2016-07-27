/**
 * Created by GGM on 2016/6/14.
 */
public class CheckIsTwoPow {

    public boolean isTwoPow(int n){
        return (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new CheckIsTwoPow().isTwoPow(8));
    }

}
