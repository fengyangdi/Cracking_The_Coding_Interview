/**
 * 根据有序数组，创建一个高度最小的二叉查找树
 * 找到中间元素，然后前后的子数组作为左右子树
 */
public class MinimalBST {
    public GenericTreeNode<Integer> buildMinimalBST(int[] vals) {
        if (vals.length <= 0) return null;
        GenericTreeNode<Integer> root;
        int mid = vals.length / 2;
        root = new GenericTreeNode<Integer>(vals[mid]);
        root.left = buildTree(vals,0,mid-1);
        root.rigth = buildTree(vals,mid+1,vals.length);
        return root;
    }

    private GenericTreeNode<Integer> buildTree(int[] vals, int start, int end) {
        if (start > end) return  null;
        int mid = (start + end) / 2;
        GenericTreeNode<Integer> root = new GenericTreeNode<Integer>(vals[mid]);
        root.left = buildTree(vals, start, mid-1);
        root.rigth = buildTree(vals, mid+1, end);
        return root;
    }
}