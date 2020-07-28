import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//给定一个仅由小写字母组成的字符串。现在请找出一个位置，删掉那个字母之后，
// 字符串变成回文。请放心总会有一个合法的解。如果给定的字符串已经是一个回文串，
// 那么输出-1
public class Palindrome {
    public static boolean isPalindrome(StringBuffer sb, int[] star, int[] end) {
        boolean result = true;
        int left = 0;
        int right = sb.length()-1;
        while(left < right) {
            if(sb.charAt(left) != sb.charAt(right)) {
                result = false;
                break;
            }
            left++;
            right--;
        }
        if(star != null)
            star[0] = left;
        if(end != null)
            end[0] = right;
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num; i++) {
            StringBuffer sb = new StringBuffer(in.next());

            int[] star = new int[1];
            int[] end = new int[1];

            if(isPalindrome(sb, star, end)) {
                System.out.println(-1);
            }else {
                sb.deleteCharAt(end[0]);
                if(isPalindrome(sb, null, null)) {
                    System.out.println(end[0]);
                }else{
                    System.out.println(star[0]);
                }
            }
        }
    }
}
