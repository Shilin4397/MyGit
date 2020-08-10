/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class RootSum {
    public class Robot {
        public int countWays(int x, int y) {
            // write code here
            int[][] result = new int[x][y];
            for(int i = 0; i < x; i++) {
                result[i][0] = 1;
            }
            for(int j = 0; j < y; j++) {
                result[0][j] = 1;
            }
            for(int i = 1; i < x; i++) {
                for(int j = 1; j < y; j++) {
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
            return result[x-1][y-1];
        }
    }
}
