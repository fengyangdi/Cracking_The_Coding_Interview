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
    public boolean isPalindrome(ListNode pHead) {
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
}