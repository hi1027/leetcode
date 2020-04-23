/**
 * @author: zhangsen
 * @date: 2020/4/20 上午10:34
 * @version: 1.0
 * @description: 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A328_奇偶链表 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(oddEvenList(n1));
    }

    public static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddEnd = head;
        ListNode even = head.next;
        ListNode evenEnd = even;

        while (evenEnd != null && evenEnd.next != null){
            oddEnd.next = evenEnd.next;
            oddEnd = oddEnd.next;
            evenEnd.next = oddEnd.next;
            evenEnd = evenEnd.next;
        }

        oddEnd.next = even;
        return head;
    }
}
