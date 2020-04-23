/**
 * @author: zhangsen
 * @date: 2020/4/16 上午1:18
 * @version: 1.0
 * @description:
 */
public class A104_二叉树的最大深度 {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int right = maxDepth(root.right);


        return leftDepth > right ? leftDepth+1:right+1;

    }
}



    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }