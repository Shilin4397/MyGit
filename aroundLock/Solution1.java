package gitIrony.binaryTreeTopk;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k <= 0 )
            return null;
        Stack<TreeNode> s = new Stack<>();
        int index = 1;
        TreeNode cur = pRoot;
        while(!s.empty() || cur != null) {
            while(cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if(index == k){
                return cur;
            }
            index++;
            cur = cur.right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Solution s = new Solution();
        if(s.KthNode(t1,8) != null) {
        System.out.println(s.KthNode(t1,8).val);
        }else {
            System.out.println("null");
        }
    }
}
