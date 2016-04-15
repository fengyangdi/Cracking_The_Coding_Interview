import java.util.Stack;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Palindrome {
    /**
     * 使用栈保存前半部分的值，然后遍历后半部分的节点，和栈中元素进行比较判断是否回文
     * 遇到不相同的则不是回文
     * @param pHead 输入的链表
     * @return 返回是否是回文
     */
    public boolean isPalindrome1(ListNode pHead) {
        Stack<Integer> stack = new Stack<>();
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        //链表的个数为奇数时，循环结束fast指向链表最后一个节点，偶数时指向空
        //当链表个数为奇数时，需要去掉中间的节点
        if (fast != null) slow = slow.next;

        //依次遍历链表后半部分的节点，与栈中元素比较，判断是否回文
        while (slow != null){
            int tmpValue = stack.pop();
            if (slow.val != tmpValue) return false;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 第二种实现，使用递归的方式进行回文判断，需要定义新的数据结构以支持递归
     * @param pHead 输入的链表
     * @return 返回是否是回文
     */
    public boolean isPalindrome(ListNode pHead) {
        int len = getLength(pHead);
        ListAndBoolean lab = recursive(pHead,len);
        return lab.result;
    }

    /**
     * 递归函数
     * @param pHead 当前层的头
     * @param len 当前层的节点个数
     * @return 返回上一层位于链表后半部分的节点和里层是否为回文的组和类
     */
    private ListAndBoolean recursive(ListNode pHead, int len) {
        if (pHead == null || len == 0) return new ListAndBoolean(null,true);

        // len为1或2时，进入到最里层，len为1则表示链表的节点个数为奇数，len为2时链表的节点个数为偶数
        if (len == 1){
            return new ListAndBoolean(pHead.next, true);
        }else if (len == 2){
            return new ListAndBoolean(pHead.next.next, pHead.val == pHead.next.val);
        }
        ListAndBoolean lab = recursive(pHead.next, len - 2);
        // 如果上层返回结果为false或者已经没有节点则直接返回该结果
        if (!lab.result || lab.node == null) return lab;
        // 应该返回上一层的属于后半的节点，应该当前获得返回结果的下一个节点
        return new ListAndBoolean(lab.node.next, pHead.val == lab.node.val);
    }

    private int getLength(ListNode pHead) {
        int count = 0;
        while (pHead != null) {
            count++;
            pHead = pHead.next;
        }
        return count;
    }

    private class ListAndBoolean{
        ListNode node;
        boolean result;

        public ListAndBoolean(ListNode node, boolean result){
            this.node = node;
            this.result = result;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        node.next = head;
        head = node;
        node = new ListNode(3);
        node.next = head;
        head = node;
        node = new ListNode(2);
        node.next = head;
        head = node;
        node = new ListNode(1);
        node.next = head;
        head = node;
        System.out.println(new Palindrome().isPalindrome(head));
    }
}