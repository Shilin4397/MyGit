import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//输入一个递增排序的数组和一个数字S，在数组中查找两个数，
// 使得他们的和正好是S，如果有多对数字的和等于S，
// 输出两个数的乘积最小的。
public class FindSmallSum {
    public int findIndex(int [] array,int sum) {
        for (int i = 0; i < array.length; i++) {
            if(array[i]>= sum) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();

        //先找到目标数字的下标
        int index = findIndex(array,sum);
        if(index == -1)
            index = array.length;

        for(int i = 0; i < index-1; i++) {
            for(int j = i+1; j < index; j++) {
                if(array[i] + array[j] == sum) {
                    l.add(array[i]);
                }
            }
        }
        if(l.size() == 0)
            return list;
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for(Integer x : l) {
            int tmp = x*(sum-x);
            if(min >= tmp){
                min = tmp;
                ret = x;
            }
        }
        if(ret > sum-ret) {
            list.add(sum-ret);
            list.add(ret);
        }else{
            list.add(ret);
            list.add(sum-ret);
        }
        return list;
    }

    public static void main(String[] args) {
        FindSmallSum f = new FindSmallSum();
        int[] arr = {1,2,4,7,11,16};
        System.out.println(f.FindNumbersWithSum(arr,10));
    }
}
