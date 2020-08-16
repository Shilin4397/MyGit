import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class EggTwistingMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            StringBuilder sb = new StringBuilder();
            while(n > 0) {
                if(n%2 == 0) {
                    n = (n-2)/2;
                    sb.insert(0,"3");
                }else{
                    n = (n-1)/2;
                    sb.insert(0,"2");
                }
            }
            if(n == 0) {
                System.out.println(sb);
            }else{
                System.out.println(0);
            }
        }
    }
}
