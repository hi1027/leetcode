import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zhangsen
 * @date: 2020/4/19 下午11:28
 * @version: 1.0
 * @description:
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class A234_回文链表 {
    public static void main(String[] args) throws CloneNotSupportedException {


        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(33);
        ListNode a4 = new ListNode(1);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        System.out.println(isPalindrome(a1));

    }


    public static boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }

        List<ListNode> reverse = new ArrayList<>(list);
        Collections.reverse(reverse);

        int size = list.size()-1;

        while (size >=0 ){
            if(list.get(size).val != reverse.get(size).val){
                return false;
            }
            size--;
        }
        return true;
    }

}


