import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class LongString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String str = in.nextLine();
            String ss = mustLong(str);
            System.out.println(ss);
        }
    }

    private static String mustLong(String str) {
        String result = "";
        int star = 0;
        int end = 0;
        int count = 0;
        int max = 0;
        int flag = 0;
        while (end < str.length()) {
            char s = str.charAt(star);
            char e = str.charAt(end);
            if(s <= '9' && s >= '0' && (e > '9' || e < '0')){
                if(count > max) {
                    max = count;
                    result = str.substring(star,end);
                }
                count = 0;
                star = end;
            }
            if( e <= '9' && e >= '0' ) {
                end++;
                count++;
            }
            else {
                end++;
                star++;
            }
        }
        if(str.charAt(end-1) >= '0' && str.charAt(end-1) <= '9' && count > max)
            result = str.substring(star,end);
        return result;
    }
}
