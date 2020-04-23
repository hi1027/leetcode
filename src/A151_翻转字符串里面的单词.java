import java.util.*;

/**
 * @author: zhangsen
 * @date: 2020/4/10 下午12:22
 * @version: 1.0
 * @description:
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

 *
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class A151_翻转字符串里面的单词 {
    public static void main(String[] args) {
        String s = "    hello world!   ";
        System.out.println(reverseWords1(s));
    }


    public static String reverseWords(String s) {
        if(null == s || s.length()==0){
            return "";
        }
        List<String> list = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(list);
        return String.join(" ",list);
    }

    public static String reverseWords1(String s) {
        if(null == s || s.length()==0){
            return "";
        }
        List<String> list = new ArrayList<>();
        String prev = null;
        for(int i = s.length()-1;i>0;i--){
            char c = s.charAt(i);
            String temp = String.valueOf(c);

            if(prev == null){
                if(!" ".equals(temp)){
                    prev = temp;
                    list.add(temp);
                }
            }else{
                if(!" ".equals(temp)){
                    list.add(temp);
                }else if(!temp.equals(prev)){
                    list.add(temp);
                }
            }
        }

        System.out.println(list);

        return null;
    }


}
