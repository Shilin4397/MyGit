import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */

//某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数；
// 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
// 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，
// 使得总预计消费金额最大

public class Table {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] table = new int[n];
            for (int i = 0; i < n; i++) {
                table[i] = in.nextInt();
            }
            int[][] people = new int[m][2];
            for (int i = 0; i < m; i++) {
                people[i][0] = in.nextInt();
                people[i][1] = in.nextInt();
            }
            Arrays.sort(table);
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            long money = 0L;
            int index = 0;
            boolean[] tableFlag = new boolean[n];
            for (int i = 0; i < m; i++) {
                if(people[i][0] > table[n-1])
                    continue;
                index = bs(table, people[i][0]);
                while(index < n && tableFlag[index])
                    index++;
                if(index < n) {
                    money += people[i][1];
                    tableFlag[index] = true;
                }
            }
            System.out.println(money);
        }
        in.close();
    }

    private static int bs(int[] table, int person) {
        int left = 0;
        int right = table.length-1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) >> 1;
            if(table[mid] >= person) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
