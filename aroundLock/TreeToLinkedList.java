import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class TreeToLinkedList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        Stack<TreeNode> s = new Stack<>();
        TreeNode root = pRootOfTree;
        TreeNode cur = root;
        TreeNode head = new TreeNode(0);
        TreeNode pre = head;
        while(cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            pre.right = cur;
            cur.left = pre;
            pre = pre.right;
            cur = cur.right;
        }
        head = head.right;
        head.left = null;
        return head;
    }

    public void print(TreeNode root) {
        while(root.right != null) {
            System.out.print(root.val+" ");
            root = root.right;
        }
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(12);
        TreeNode t7 = new TreeNode(16);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TreeToLinkedList t = new TreeToLinkedList();
        TreeNode r =  t.Convert(t1);
        t.print(r);
        System.out.println();
    }
}
