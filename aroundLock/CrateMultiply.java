/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class CrateMultiply {
    public int[] multiply(int[] A) {
        if(A.length <= 0){
            return A;
        }
        int len = A.length;
        int[] B = new int[len];
        int sum = 1;
        for (int i = 0; i < len; i++) {
            int tmp = 1;
            for (int j = i+1; j < len; j++) {
                tmp *= A[j];
            }
            B[i] = tmp * sum;
            sum *= A[i];
        }
        return B;
    }
}
