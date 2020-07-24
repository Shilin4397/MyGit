/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class IsBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)
            return false;
        if( sequence.length <= 2)
            return true;
        boolean bool = verifySquence(sequence, 0, sequence.length-1);
        return bool;
    }

    public boolean verifySquence(int[] sequence, int star, int end) {
        //如果当前区间中元素个数是 1 则为叶子节点返回 true
        if(end - star < 1) {
            return true;
        }
        int i = 0;
        //区间最后一个节点为当前二叉树的根
        //从区间左侧向右遍历，第一次遇到大于根的节点，
        //该节点及以后的节点为根的右子树
        for(; i < end; i++) {
            if(sequence[i] > sequence[end])
                break;
        }
        int index = i;
        for(; i < end; i++) {
            if(sequence[i] < sequence[end])
                return false;
        }
        //左子树和右子树同时满足
        return verifySquence(sequence, star, index-1) && verifySquence(sequence, index, end-1);
    }
}
