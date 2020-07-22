import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//把一个32-bit整型转成二进制，其中包含多少个1，
// 比如5的二进制表达是101，其中包含2个1
public class Count1 {
    public static int fun(int n) {
        int count = 0;
        while(n > 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fun(n));
    }
}
