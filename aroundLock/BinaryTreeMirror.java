import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//操作给定的二叉树，将其变换为源二叉树的镜像。
public class BinaryTreeMirror {
    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode cur = stack.pop();
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
            TreeNode cur1;
            cur1 = cur.right;
            cur.right = cur.left;
            cur.left = cur1;
        }
    }

    //方法二
    public void Mirror2(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;
        Mirror(root.left);
        Mirror(root.right);
    }
}
