import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class MinNum {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }
        while(k > 0) {
            list.add(queue.poll());
            k--;
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,2,3,6,1,7,8};
        System.out.println(GetLeastNumbers_Solution(arr,4));
    }
}
