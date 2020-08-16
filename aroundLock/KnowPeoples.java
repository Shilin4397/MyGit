import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class KnowPeoples {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            int n = in.nextInt();
            int ai = in.nextInt();
            int m = in.nextInt();
            int[][] people = new int[m][2];
            for(int i = 0; i < m; i++) {
                String[] strs = in.nextLine().split(",");
                people[i][0] = Integer.parseInt(strs[0]);
                people[i][1] = Integer.parseInt(strs[1]);
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < m; i++) {
                if(people[i][0] == ai || people[i][1] == ai) {

                }
            }
        }
    }
}
