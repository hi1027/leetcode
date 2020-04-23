/**
 * @author: zhangsen
 * @date: 2020/4/18 下午4:26
 * @version: 1.0
 * @description:
 */
public class A21_合并两个有序链表 {
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

        mergeTwoLists(a1, b1);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                lastNode.next = l1;
                lastNode = lastNode.next;
                l1 = l1.next;
            }else{
                lastNode.next = l2;
                lastNode = lastNode.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            lastNode.next = l2;
        } else {
            lastNode.next = l1;
        }

        return dummy.next;
    }



}


class ListNode{
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


}