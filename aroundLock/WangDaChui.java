import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class WangDaChui {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            for(int i = 0; i < n; i++) {
                String str = in.nextLine();
                System.out.println(inspect(str));
            }
        }
    }
    public static String inspect(String str) {
        char[] chs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(int i = 0; i < chs.length; i++) {
            chs[k] = chs[i];//将当前k位置的字符修改
            sb.append(chs[k]);
            k++;
            if(k >= 3 && chs[k-3] == chs[k-2] && chs[k-2] == chs[k-1]) {
                sb.deleteCharAt(k-1);
                k--;
            }
            if(k >= 4 && chs[k-4] == chs[k-3] && chs[k-2] == chs[k-1]) {
                sb.deleteCharAt(k-1);
                k--;
            }
        }
        return String.valueOf(sb);
    }
}
