import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
// 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
// 则打印出这三个数字能排成的最小数字为321323。
public class MinNumber {
    public static String PrintMinNumber(int [] numbers) {
        if(numbers == null)
            return new String();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int e: numbers) {
            list.add(e);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                String xs = x + "" + y;
                String ys = y + "" + x;
                return xs.compareTo(ys);
            }
        });
        String result = new String();
        for(Integer e: list) {
            result += e;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,32,321};
        String str = PrintMinNumber(arr);
        System.out.println(str);
    }
}
