/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//在数组中的两个数字，如果前面一个数字大于后面的数字，
// 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
// 并将P对1000000007取模的结果输出。 即输出P%1000000007
//输入1,2,3,4,5,6,7,0
 //输出 7
public class InversePairss {
    public static int InversePairs(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        int count = InversePairsCore(array,copy,0,array.length-1);
        return count;
    }
    private  static int InversePairsCore(int[] array,int[] copy,int left,int right){
        if(right == left) {
            return 0;
        }
        int mid = (right + left) >> 1;//中间位置
        //向左查找
        int leftCount = InversePairsCore(array,copy,left,mid)%1000000007;
        //向右查找
        int rightCount = InversePairsCore(array,copy,mid+1,right)%1000000007;
        int count = 0;//记录逆序数
        int i = mid;
        int j = right;
        int index = right;
        //mid两侧已经有序，所以两侧各自都无逆序数
        while(i >= left && j > mid) {
            if(array[i] > array[j]) {
                count += j-mid; //j到mid已经有序，j位置最大，所有此时的逆序数为j-mid;
                copy[index--] = array[i--];
                if(count >= 1000000007) {
                    count %= 1000000007;//数值过大求余
                }
            }else {
                copy[index--] = array[j--];
            }
        }
        //左侧没有遍历完的为较小值
        for(; i >= left; i--) {
            copy[index--] = array[i];
        }
        //右侧没有遍历完的为较小值
        for(; j > mid; j--) {
            copy[index--] = array[j];
        }
        //将排序好的数组拷贝会array数组中
        System.arraycopy(copy, left, array, left, right-left+1);
        return (leftCount+rightCount+count)%1000000007;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        int[] array={4,3,2,1};
        int n = InversePairs(array);
        System.out.println(n);

    }
}
