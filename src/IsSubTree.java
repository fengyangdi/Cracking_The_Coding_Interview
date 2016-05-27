/**
 * Created by GGM on 2016/5/26.
 */
public class IsSubTree {
    public boolean isSubTree(TreeNode t1, TreeNode t2){
        if (t2 == null) return  true;
        return check(t1,t2);
    }

    private boolean check(TreeNode t1, TreeNode t2) {
        //如果t1已经没有子节点
        if (t1 == null) return false;

        if (t1.val == t2.val) {
            if (match(t1,t2)) return true;
        }
        //检查子树中是否有t2
        return check(t1.left, t2) || check(t1.right, t2);

    }

    private boolean match(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        //判断左右子树是否相同
        return match(t1.left,t2.left) && match(t1.right, t2.right);
    }
}
