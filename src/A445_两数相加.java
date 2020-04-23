import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangsen
 * @date: 2020/4/14 下午5:17
 * @version: 1.0
 * @description:
 */
public class A445_两数相加 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    [7,2,4,3]
//            [5,6,4]

    public static void main(String[] args) {

        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(4);

        n5.next = n6;
        n6.next = n7;

        addTwoNumbers1(n1, n5);
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }

        String s1 = sb1.toString();
        String s2 = sb2.toString();
        int length = sb1.length() - sb2.length();

        StringBuffer sb = new StringBuffer();

        if(length != 0){
            int abs = Math.abs(length);
            while (abs > 0){
                sb.append("0");
                abs--;
            }
            if (length > 0) {
                sb.append(sb2);
                s2 = sb.toString();
            } else {
                sb.append(sb1);
                s1 = sb.toString();
            }
        }

        length = s1.length();

        List<ListNode> list = new ArrayList<>();

        int flag = 0;
        for (int j = length-1; j >= 0; j--) {

            int num1 = Integer.parseInt(String.valueOf(s1.charAt(j)));
            int num2 = Integer.parseInt(String.valueOf(s2.charAt(j)));

            int num = num1 + num2 + flag;
            int val ;
            if (num / 10 >  0) {
                flag = 1;
                val =num%10;
            } else {
                val = num;
                flag = 0;
            }
            ListNode node = new ListNode(val);
            list.add(node);
        }

        if(flag > 0){
            ListNode node = new ListNode(flag);
            list.add(node);
        }


        for (int k = list.size()-1; k >=0; k--) {
            if (k > 0) {
                list.get(k).next = list.get(k - 1);
            }
        }

        return list.get(list.size()-1);

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }

        StringBuffer reverse1 = sb1.reverse();
        StringBuffer reverse2 = sb2.reverse();

        int length = sb1.length() - sb2.length();
        if (length > 0) {
            while (length > 0) {
                reverse2.append("0");
                length--;
            }
        } else if (length < 0) {
            while (length < 0) {
                reverse1.append("0");
                length++;
            }
        }

        String s1 = reverse1.toString();
        String s2 = reverse2.toString();
        length = s1.length();

        List<ListNode> list = new ArrayList<>();

        int flag = 0;
        for (int j = 0; j < length; j++) {

            int num1 = Integer.parseInt(String.valueOf(s1.charAt(j)));
            int num2 = Integer.parseInt(String.valueOf(s2.charAt(j)));

            int num = num1 + num2 + flag;
            int val ;
            if (num / 10 >  0) {
                flag = 1;
                val =num%10;
            } else {
                val = num;
                flag = 0;
            }
            ListNode node = new ListNode(val);
            list.add(node);
        }

        if(flag > 0){
            ListNode node = new ListNode(flag);
            list.add(node);
        }


        for (int k = list.size()-1; k >=0; k--) {
            if (k > 0) {
                list.get(k).next = list.get(k - 1);
            }
        }

        return list.get(list.size()-1);

    }
}
