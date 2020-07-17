/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class ArrayFind {
    public boolean Find(int target, int [][] array) {
        if(array.length <= 0)
            return false;
        int row = 0;
        int rows = array.length;
        int col = array[0].length-1;
        while(row < rows && col >= 0) {
            int tmp = array[row][col];
            if(target > tmp) {
                row++;
            }else if (target < tmp) {
                col--;
            }else{
                return true;
            }
        }
        return false;
    }
}
