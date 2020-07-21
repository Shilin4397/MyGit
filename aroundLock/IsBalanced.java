/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */

//输入一棵二叉树，判断该二叉树是否是平衡二叉树。
//在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
public class IsBalanced {
    public int hight(TreeNode root) {
        if(root == null)
            return 0;
        int left = 1+hight(root.left);
        int right = 1+hight(root.right);
        return left > right ? left : right;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = hight(root.left);//左子树高度
        int right = hight(root.right);//右子树高度
        if(Math.abs(left - right) <= 1) {//左右子树高度差不超过1
            //左右子树必须同时满足
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.left);
        }
        return false;

    }
}
