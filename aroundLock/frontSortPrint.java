package gitIrony.aroundLock;



import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}


//    请实现一个函数按照之字形打印二叉树，
//    即第一行按照从左到右的顺序打印，
//    第二层按照从右至左的顺序打印，
//    第三行按照从左到右的顺序打印，其他行以此类推。

public class frontSortPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);
        int flag = 1;
        while (!q.isEmpty()) {
            ArrayList<Integer> l = new ArrayList<>();
            TreeNode cur = null;
            int se = q.size();
            while (se > 0) {
                cur = q.poll();
                l.add(cur.val);
                if(cur.left != null)
                    q.offer(cur.left);
                if(cur.right != null)
                    q.offer(cur.right);
                se--;
            }
            if(flag == 1) {
                flag = 2;
                list.add(l);
            }else {
                flag = 1;
                Collections.reverse(l);
                list.add(l);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        frontSortPrint f = new frontSortPrint();
        TreeNode r1 = new TreeNode(8);
        TreeNode r2 = new TreeNode(10);
        TreeNode r3 = new TreeNode(6);
        TreeNode r4 = new TreeNode(5);
        TreeNode r5 = new TreeNode(7);
        TreeNode r6 = new TreeNode(9);
        TreeNode r7 = new TreeNode(11);

        r1.right = r3;
        r1.left = r2;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;

        ArrayList<ArrayList<Integer>> list = f.Print(r1);
        for (ArrayList<Integer> ls: list) {
            System.out.println(ls.toString());
        }
    }
}