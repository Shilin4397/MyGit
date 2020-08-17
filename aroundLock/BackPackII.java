/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class BackPackII {
    public int backPack(int m, int[] A, int[] V) {
        int num = A.length;
        if(m == 0 || num == 0)
            return 0;
        int[] max = new int[m+1];
        for (int i = 0; i <= m; i++) {
            max[i] = 0;
        }
        for (int i = 0; i <= num; i++) {
            for (int j = m; j > 0; j--) {
                //如果第i个商品大于j,说明放不下， 所以(i,j)的最大价值和(i-1,j)相同
                //如果可以装下，分两种情况，装或者不装
                //如果不装，则即为(i-1, j)
                //如果装，需要腾出放第i个物品大小的空间： j - A[i],
                // 装入之后的最大价值即为(i - 1, j- A[i-1]) + 第i个商品的价值V[i]
                //最后在装与不装中选出最大的价值
                if(A[i-1] <= j) {
                    int ret = max[j-A[i-1]] + V[i-1];
                    max[j] = Math.max(ret,max[j]);
                }
            }
        }
        return max[m];
    }
}
