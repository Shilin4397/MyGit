import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//把只包含质因子2、3和5的数称作丑数（Ugly Number）。
// 例如6、8都是丑数，但14不是，因为它包含质因子7。
// 习惯上我们把1当做是第一个丑数。
// 求按从小到大的顺序的第N个丑数。
public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        //1到6全是丑数
        if(index<7) return index;
        int[] ret = new int[index];
        ret[0]=1;
        int t2=0,t3=0,t5=0;
        for(int i=1;i<index;i++) {
            //当前位置的丑数为上一层的三个丑数乘2，3，5最小的一个数
            ret[i] = min(min(ret[t2]*2,ret[t3]*3),ret[t5]*5);
            //本次乘以几，就给谁加一，代表改丑数的质因子中有几个该数。
            if(ret[i] == ret[t2]*2) t2++;
            if(ret[i] == ret[t3]*3) t3++;
            if(ret[i] == ret[t5]*5) t5++;
        }
        return ret[index-1];
    }
    //获得较小值
    public static int min(int a,int b) {
        return a<b ? a : b;
    }

    public static void main(String[] args) {
        UglyNumber u = new UglyNumber();
//        boolean b = u.fun(7);
        int n = u.GetUglyNumber_Solution(7);
        System.out.println(n);

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
    }
}
