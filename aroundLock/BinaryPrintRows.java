import java.util.ArrayList;
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
//从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
public class BinaryPrintRows {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);
        while (!q.isEmpty()){
            ArrayList<Integer> l = new ArrayList<>();
            int se = q.size(); //得到当前队列中的元素个数
            while(se > 0) {
                TreeNode cur = q.poll();
                //将当前节点的左右孩子入队列，及下一层节点入队列
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
                l.add(cur.val);
                se--;
            }
            list.add(l);
        }

        return list;
    }
}