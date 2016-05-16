/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/

/**
 * 判断二叉树是否为二叉查找树
 * 中序遍历可以得到一个二叉查找树的正序排序，上一次访问则为本次访问的前一个值
 * 使用中序遍历，每次记录上一次访问的值，与本次访问比较
 */
public class Checker {

    private static int lastValue = Integer.MIN_VALUE;

    public boolean checkBST(TreeNode root) {
        if (root == null) return true;
        if (!checkBST(root.left)) return  false;

        if (root.val <= lastValue) return false;
        lastValue = root.val;

        if (!checkBST(root.right)) return false;

        return  true;
    }
}