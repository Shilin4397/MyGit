/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */

//输入两棵二叉树A，B，判断B是不是A的子结构。
// （ps：我们约定空树不是任意一个树的子结构）
public class TreeChildStructure {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)
            return false;
        boolean result = false;
        if(root1.val == root2.val) {
            result = IsSame(root1,root2);
        }
        if(!result) {
            result = HasSubtree(root1.left, root2);
        }
        if(!result) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }
    public boolean IsSame(TreeNode root1, TreeNode root2) {
        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }
        if(root1.val == root2.val) {
            return IsSame(root1.left, root2.left) && IsSame(root1.right, root2.right);
        }else{
            return false;
        }
    }
}
