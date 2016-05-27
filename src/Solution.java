import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        //定义一个栈存放用于遍历节点，并判断该节点的右子树是否已经遍历
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
        ArrayList<Boolean> stackIsRightVisited = new ArrayList<Boolean>();
        if (root == null) return paths;
        stack.add(root);
        stackIsRightVisited.add(false);
        int sum = 0;
        while (stack.size() > 0){
            TreeNode node = stack.get(stack.size() - 1);
            if (node != null) sum += node.val;
            if (sum == target) {
                //当和相等时，如果还有子节点，则不是路径，退回到父节点，继续遍历，如果是叶结点
                //则从根节点到该节点的路径符合要求，加入列表，并退回父节点，继续
                if (node.left == null && node.right == null){
                    //加入队列
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for (TreeNode treeNode : stack){
                        list.add(treeNode.val);
                    }
                    paths.add(list);
                }
                //回退上一层
                sum = backToUpper(stack,stackIsRightVisited,sum);
            }else if (sum > target){
                sum = backToUpper(stack,stackIsRightVisited,sum);
            }else{
                if (node.left != null) {
                    stack.add(node.left);
                    stackIsRightVisited.add(false);
                }
                else if (node.right != null) {
                    stackIsRightVisited.set(stackIsRightVisited.size()-1,true);
                    stack.add(node.right);
                    stackIsRightVisited.add(false);
                }else{
                    //回退上一层
                    sum = backToUpper(stack,stackIsRightVisited,sum);
                }
            }
        }
        return paths;
    }

    private int backToUpper(ArrayList<TreeNode> stack, ArrayList<Boolean> stackIsRightVisited, int sum) {
        while (stack.size() > 0){
            int last = stack.size() - 1;
            TreeNode remove = stack.remove(last);
            //回退需要，减去当前的值
            sum -= remove.val;
            stackIsRightVisited.remove(last);
            //判断栈顶元素是否需要遍历右子树
            if (stack.size()>0){
                TreeNode node = stack.get(last - 1);
                Boolean isNeedToadd = !stackIsRightVisited.get(last - 1);
                if (node.right != null && isNeedToadd){
                    stackIsRightVisited.set(last - 1,true);
                    stack.add(node.right);
                    stackIsRightVisited.add(false);
                    //退出
                    return sum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(12);
        TreeNode node5 = new TreeNode(0);

        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        node2.left = node5;

        System.out.println(new Solution().FindPath(root,22));

    }
}