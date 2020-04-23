/**
 * @author: zhangsen
 * @date: 2020/4/18 下午3:21
 * @version: 1.0
 * @description: 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A206_反正链表 {


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
        n5.next = null;

        reverseList2(n1);
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        //定义 虚拟哨兵头结点 ，用来接收反正的指向
        ListNode pre = null;
        //定义当前迭代的节点
        ListNode cur = head;
        while (cur != null){
            //记录下个节点
            ListNode temp = cur.next;
            //把当前节点的下个节点指向他的前节点   1->2->3   比如迭代的是2  就把2-> 指向1，这就完成了反转，
            // 千万别想着后面还有3 ，4 等等，我们只需要完成每次迭代自己该做的事情，至于其他节点怎么做，不是我们自己需要关心的，
            // 当跌到到其他的节点的时候，他自己会做的，
            cur.next = pre;
            // 把前节点 和 当前节点都往后移动，继续迭代
            pre = cur;
            cur= temp;
        }
        return pre;
    }



    /**
     * 递归  递归模板
     *      1、递归的终止条件
     *      2、递归该做的事情
     *      3、返回上一层的数据
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        //终止条件
        if(head == null || head.next == null){
            return head;
        }
        //该做的事情
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        //这一步 的意思 就是切断关系，避免循环链表
        head.next = null;
        //返回给上一次的值
        return node;
    }

}


