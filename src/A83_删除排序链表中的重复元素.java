import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhangsen
 * @date: 2020/4/18 下午7:20
 * @version: 1.0
 * @description: 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A83_删除排序链表中的重复元素 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        deleteDuplicates1(node1);

    }

    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
           if(curr.val == curr.next.val){
               curr.next = curr.next.next;
           }else{
               curr = curr.next;
           }
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (set.add(head.val)) {
                ListNode node = new ListNode(head.val);

                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = node;

            }
            head = head.next;
        }
        return dummy.next;
    }


}

