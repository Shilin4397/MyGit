/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class DuplicateNum {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        //记录当前数字是否存在
        boolean[] k = new boolean[length];
        for (int i = 0; i < length; i++) {
            //如果当前数字对应位置为true，则说明当前数字已经存在
            if (k[numbers[i]] == true) {
                //记录重复的数字
                duplication[0] = numbers[i];
                return true;
            }
            //将每次遍历的数字对应位置设为true
            k[numbers[i]] = true;
        }
        return false;
    }
}
