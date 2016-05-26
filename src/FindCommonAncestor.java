/**
 * Created by GGM on 2016/5/26.
 */
public class FindCommonAncestor {

    private class RecursionResult{
        TreeNode node;      //返回结果
        boolean isAncestor; //返回结果是否是祖先节点

        RecursionResult(TreeNode _node, boolean _isAncestor){
            this.node = node;
            this.isAncestor = _isAncestor;
        }
    }

    public TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        RecursionResult rr = commonAncestor(root, p, q);
        if (rr.isAncestor) return rr.node;
        return null;
    }

    private RecursionResult commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果root是空，则返回空，且不是祖先节点
        if (root == null) return new RecursionResult(null,false);

        if (root == p && root == q) return new RecursionResult(root, true);

        RecursionResult rrl = commonAncestor(root.left, p, q);
        //如果左子树返回的是祖先节点则直接返回
        if (rrl.isAncestor){
            return rrl;
        }

        RecursionResult rrRight = commonAncestor(root.left, p, q);
        //如果右子树返回的是祖先节点则直接返回
        if (rrRight.isAncestor){
            return rrRight;
        }

        if (rrl.node != null && rrRight.node != null){
            //左右子树各找到一个，则当前节点为共同祖先节点
            return new RecursionResult(root,true);
        }else if (root == p || root ==q){
            //root是其中一个节点，当左右子树中包含另外一个节点则当前节点为共同祖先节点，否则返回当前节点，且不是祖先节点
            boolean isAncestor = rrl.node != null || rrRight != null;
            return new RecursionResult(root, isAncestor);
        }else {
            //如果左右子树中有节点，返回带有找到节点的结果
            return rrl.node != null ? rrl : rrRight;
        }

    }
}
