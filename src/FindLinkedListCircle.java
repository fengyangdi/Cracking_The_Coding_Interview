/**
 * Created by GGM on 2016/4/15.
 */
public class FindLinkedListCircle {
    public LinkedListNode getStartOfCircle(LinkedListNode head){
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }

        //当前面的指针指向空或者其下一个是空的时候，说明链表不存在环，因此返回null
        if (fast == null || fast.next == null) return null;

    }
}
