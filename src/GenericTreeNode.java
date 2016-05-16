/**
 * Created by GGM on 2016/4/29.
 * 树结构的简单定义
 */
public class GenericTreeNode<T> {
    T val;
    GenericTreeNode<T> left;
    GenericTreeNode<T> rigth;

    public GenericTreeNode(T _val) {
        this.val = _val;
    }
}
