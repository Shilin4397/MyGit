/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class LeftRotateString {
    public String leftRotateString(String str,int n) {
        if("".equals(str)){
            return str;
        }
        n = n % str.length();
        String s1 = str.substring(0,n);
        String s2 = str.substring(n);
        return s2+s1;
    }
}
