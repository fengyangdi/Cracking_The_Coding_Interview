import java.util.*;

/**
 * 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。
 * 请设计一个算法，求出a和b点的最近公共祖先的编号。
 * 给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
 */

public class LCA {
    public int getLCA(int a, int b) {
        int aLayer = (int)(Math.log(a)/Math.log(2));
        int bLayer = (int)(Math.log(b)/Math.log(2));
        //走到同一层
        if (aLayer > bLayer) {
            a /= (int)Math.pow(2,aLayer-bLayer);
        }else if (aLayer < bLayer){
            b /= (int)Math.pow(2,bLayer-aLayer);
        }
        //往上搜寻
        while (a > 1 && b > 1){
            if (a == b) return a;
            //a,b都往上走一层,知道走到共同祖先节点
            a /= 2;
            b /= 2;
        }
        return 1;
    }

    public static void main(String[] args) {
        LCA lca = new LCA();
        System.out.println(lca.getLCA(135943,141324));
    }
}