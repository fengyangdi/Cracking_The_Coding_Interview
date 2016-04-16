/**
 * 链表表示的两个整数的和（正序，1->2 = 12）
 */
public class LinkedListAdder {

    /**
     * 递归调用返回类型
     * node 为计算后的节点
     * adder 进位数
     */
    private class NodeWithAdder{
        LinkedListNode node;
        int adder;
    }

    public LinkedListNode adder(LinkedListNode l1, LinkedListNode l2){
        if (l1 == null && l2 == null) return new LinkedListNode(0);
        else if(l1 == null) return l2;
        else if(l2 == null) return l1;
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        //两个链表长度对齐
        if(len1 > len2){
            for (int i = 0; i < len1 - len2; i++){
                LinkedListNode lTmp = new LinkedListNode(0);
                lTmp.next = l2;
                l2 = lTmp;
            }
        }else {
            for (int i = 0; i < len2 - len1; i++){
                LinkedListNode lTmp = new LinkedListNode(0);
                lTmp.next = l1;
                l1 = lTmp;
            }
        }
        //递归计算两链表和
        NodeWithAdder nwa = addRecursion(l1,l2);
        return nwa.node;
    }

    /**
     * 递归计算两个链表代表的整数的和
     * @param l1 第一个整数的链表
     * @param l2 第二个整数的链表
     * @return 返回包含已经计算的结果和进位数
     */
    private NodeWithAdder addRecursion(LinkedListNode l1, LinkedListNode l2) {
        //当递归到最后，则返回一个空的节点和进位数为0
        if(l1 == null && l2 == null) return new NodeWithAdder();
        //获得上一层的返回结果
        NodeWithAdder nwa = addRecursion(l1.next,l2.next);
        NodeWithAdder re = new NodeWithAdder();
        //根据进位数与当前位置的数计算和
        int sum = l1.val + l2.val + nwa.adder;
        //判断是否进位
        if(sum > 9) {
            re.adder = 1;
            sum %= 10;
        }
        LinkedListNode node = new LinkedListNode(sum);
        //将当前结果节点添加到返回的链表的头，形成新的链表
        node.next = nwa.node;
        re.node = node;
        return re;
    }

    //计算链表长度
    private int getLength(LinkedListNode l) {
        int count = 0;
        while (l != null) {
            count++;
            l = l.next;
        }
        return count;
    }

    public static void main(String[] args) {
        //l1 为 1->2->3
        LinkedListNode l1 = new LinkedListNode(1);
        LinkedListNode node = new LinkedListNode(2);
        l1.next = node;
        node = new LinkedListNode(3);
        l1.next.next = node;

        //l2 为 1->3
        LinkedListNode l2 = new LinkedListNode(1);
        node = new LinkedListNode(3);
        l2.next = node;

        LinkedListNode newList = new LinkedListAdder().adder(l1,l2);
        while(newList!=null){
            System.out.print(newList.val);
            newList = newList.next;
        }
    }
}
