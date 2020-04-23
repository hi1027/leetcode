import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhangsen
 * @date: 2020/4/19 下午5:31
 * @version: 1.0
 * @description:
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 */
public class A160_相交链表 {

    public static void main(String[] args) {


        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(7);

        a1.next = a2;
        a2.next = a3;


        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(5);
        ListNode b3 = new ListNode(6);

        b1.next = b2;
        b2.next = b3;
        b3.next = a3;


        // a1   a1->a2->a3
        // b1   b1->b2->b3->a3

        getIntersectionNode(a1,b1);

    }

    //hash表做，如果是带环的链表  则要注意一点，就是怎么判断是否遍历完
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        Set set = new HashSet();

        while (headA != null){
            if(!set.add(headA)){
                headA = null;
            }
            headA = headA.next;
        }

        while (headB != null){
            if(!set.add(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


}


