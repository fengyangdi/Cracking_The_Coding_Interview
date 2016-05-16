/**
 * Created by GGM on 2016/4/29.
 * 判断树是否平衡
 */
public class CheckTreeIsBalance {
    /**
     * 判断树是否平衡
     * @param root 树的根
     * @param <T> 泛型参数
     * @return 是否平衡
     */
    public static <T> boolean isBalance(GenericTreeNode<T> root){
        ReTurnType re = isBalanceRecursion(root);
        return re.isBalance;
    }

    private static <T> ReTurnType isBalanceRecursion(GenericTreeNode<T> root) {
        if (root == null) return new ReTurnType(true,0);
        ReTurnType left = isBalanceRecursion(root.left);
        ReTurnType right = isBalanceRecursion(root.rigth);
        int high = left.high>right.high?left.high:right.high;
        if (!left.isBalance || right.isBalance) return new ReTurnType(false,high+1);
        else {
            boolean isBalance = Math.abs(left.high-right.high) <= 1;
            return new ReTurnType(isBalance,high+1);
        }
    }

    private  static  class ReTurnType{
        boolean isBalance;
        int high;

        public ReTurnType(boolean _isBalance, int _high){
            this.isBalance = _isBalance;
            this.high = _high;
        }
    }
}
