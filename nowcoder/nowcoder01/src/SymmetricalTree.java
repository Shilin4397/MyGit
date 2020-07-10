import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
//实现一个函数，用来判断一棵二叉树是不是对称的。
// 注意，如果一个二叉树同此二叉树的镜像是同样的，
// 定义其为对称的。
public class SymmetricalTree {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) {
            return true;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = pRoot;
        while (cur != null || !s.empty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if(cur.right == null) {
                list1.add(1);
            }
            if(cur.left == null){
                list1.add(2);
            }
            list1.add(cur.val);
            cur = cur.right;
        }
        cur = pRoot;
        while (cur != null || !s.empty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.right;
            }
            cur = s.pop();
            if(cur.left == null) {
                list2.add(1);
            }
            if(cur.right == null){
                list2.add(2);
            }
            list2.add(cur.val);
            cur = cur.left;
        }
        System.out.println(list1);
        System.out.println(list2);
        if(list1.equals(list2))
            return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(5);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(5);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(5);
        TreeNode r7 = new TreeNode(5);

        r1.right = r3;
        r1.left = r2;
        r2.left = r4;
        r3.right = r5;
        r4.left = r6;
        r5.left = r7;
        SymmetricalTree s = new SymmetricalTree();
        System.out.println(s.isSymmetrical(r1));
    }
}
