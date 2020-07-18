import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        Set<Integer> set = new HashSet<>();
        for(int x: array) {
            if(set.contains(x)) {
                set.remove(x);
            }else {
                set.add(x);
            }
        }
        List<Integer> list = new ArrayList<Integer>(set);
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }

    public static void main(String[] args) {
        int[] a = {0};
        int[] b = {0};
        int[] arr = {2,4,3,6,3,2,5,5};
        FindNumsAppearOnce f = new FindNumsAppearOnce();
        f.FindNumsAppearOnce1(arr,a,b);
        System.out.println(a[0] + "  " + b[0]);
    }
}
