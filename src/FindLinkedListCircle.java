/**
 * Created by GGM on 2016/4/15.
 */
public class FindLinkedListCircle {
    public LinkedListNode getStartOfCircle(LinkedListNode head){
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        //查找两个指针第一次相遇的节点，该节点位于LOOP_SIZE-k出
        //k为头几点到环的距离，K可能大于环的节点数，因此使得k = K mod LOOP_SIZE
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }

        //当前面的指针指向空或者其下一个是空的时候，说明链表不存在环，因此返回null
        if (fast == null || fast.next == null) return null;

        //找到后，相遇点离环开始节点的距离是K，头节点到环开始节点的距离也是K
        //因此移动指针，直到两个指针相遇，即为环的开始节点
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode tail = head;
        LinkedListNode circle = null;
        for (int i = 1; i < 10; i++){
            if(i == 5){
                circle = new LinkedListNode(i);
                tail.next = circle;
                tail = circle;
            }else {
                LinkedListNode node = new LinkedListNode(i);
                tail.next = node;
                tail = node;
                if (i == 9) tail.next = circle;
            }
        }

        LinkedListNode result = new FindLinkedListCircle().getStartOfCircle(head);
        System.out.println(result);
    }
}
