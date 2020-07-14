import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
// 数值为0或者字符串不是一个合法的数值则返回0
public class StringToInt {
//    int index = 0;
//    int flag = 1;
//    public int StrToInt(String str) {
//        if(str.length() < 1)
//            return 0;
//        char[] ch = str.toCharArray();
//        int symbol = 1;
//        if(ch[index] == '+') {
//            index++;
//        }
//        if(ch[index] == '-') {
//            symbol = -1;
//            index++;
//        }
//        int before = isInt(ch);
//        if(before == -1)
//            return 0;
//        flag = 1;
//        if(index == ch.length)
//            return before*symbol;
////        if(index < ch.length && ch[index] == '.') {
////            index++;
////            int after = isInt(ch);
////            if(index < ch.length) {
////                return 0;
////            }
////            double ret = after;
////            while (flag > 1) {
////                ret /= 10;
////                flag--;
////            }
////            if(index < ch.length){
////                return 0;
////            }
////            double d = before + ret;
////            return d*symbol;
////        }
//        return 0;
//    }
//
//    private int isInt(char[] ch){
//        int tmp = -1;
//        for (; index < ch.length; index++) {
//            if(ch[index] >= '0' && ch[index] <= '9'){
//                if(flag != 1) {
//                    tmp = (ch[index] - '0') + tmp * 10;
//                }else {
//                    tmp = (ch[index] - '0');
//                }
//                flag++;
//            }else {
//                return tmp;
//            }
//        }
//        return tmp;
//    }


    int index = 0;
    int flag = 1;
    public double StrToInt(String str) {
        if(str.length() < 1)
            return 0;
        char[] ch = str.toCharArray();
        int symbol = 1;
        if(ch[index] == '+') {
            index++;
        }
        if(index < ch.length && ch[index] == '-') {
            symbol = -1;
            index++;
        }
        int before = isInt(ch);
        if(before == -1)
            return 0;
        if(index == ch.length)
            return before*symbol;

        if(index < ch.length && ch[index] == '.') {
            index++;
            int after = isInt(ch);
            if(index < ch.length) {
                return 0;
            }
            double ret = after;
            while (flag > 1) {
                ret /= 10;
                flag--;
            }
            if(index < ch.length){
                return 0;
            }
            double d = before + ret;
            return d*symbol;
        }

        return 0;
    }

    private int isInt(char[] ch){
        int tmp = -1;
        for (; index < ch.length; index++) {
            if(ch[index] >= '0' && ch[index] <= '9'){
                if(flag != 1) {
                    tmp = (ch[index] - '0') + tmp * 10;
                }else {
                    tmp = (ch[index] - '0');
                }
                flag++;
            }else {
                return tmp;
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringToInt s = new StringToInt();
            String str = in.nextLine();
            double n = s.StrToInt(str);
            System.out.println(n);

    }
}
