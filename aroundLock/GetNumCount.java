/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */

//统计一个数字在排序数组中出现的次数。
public class GetNumCount {
    public int binaryFind (int[] array, double k){
        int left = 0;
        int right = array.length-1;
        while(left <= right) {
            int mid = (left + right)/2;
            if(array[mid] > k) {
                right = mid-1;
            }else if(array[mid] < k) {
                left = mid+1;
            }else{
                return mid;
            }
        }
        return left;
    }

    public int GetNumberOfK(int [] array , int k) {
        if(array.length <= 0)
            return 0;
        return binaryFind(array, k+0.5)-binaryFind(array,k-0.5);
    }
}
