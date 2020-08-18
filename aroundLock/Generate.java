import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class Generate {
    public static void main(String[] args) {
        Generate g = new Generate();
        List<List<Integer>> lists = g.generate(6);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numRows; ++i) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < numRows; i++) {
            list.get(i).add(1);
        }
        for (int i = 1; i < numRows; i++) {
            for(int j = 1; j < i; j++) {
                list.get(i).add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
            }
            list.get(i).add(1);
        }
        return list;
    }
}
