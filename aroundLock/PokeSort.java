import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//LL今天心情特别好,因为他去买了一副扑克牌,
// 发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
// 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
// 如果抽到的话,他决定去买体育彩票,嘿嘿！！
// “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
// 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
// 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
// LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,
// 然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
// 为了方便起见,你可以认为大小王是0。
public class PokeSort {
    public boolean isContinuous(int [] numbers) {
        //牌的数量为4
        if(numbers.length <= 0 || numbers.length > 5)
            return false;
        //记录0的个数
        int count = 0;
        //检查是否右重复元素
        Set<Integer> set = new HashSet<>();
        //最大元素
        int min = 15;
        //最小元素
        int max = -1;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0) {
                count++;
            }else{
                if(numbers[i] < min) {
                    min = numbers[i];
                }
                if(numbers[i] > max) {
                    max = numbers[i];
                }
                set.add(numbers[i]);
            }
        }
        int size = set.size();
        if(size != 5 - count)
            return false;
        if(count == 4) {//如果有四个大小王，则一定能组成顺子
            return true;
        }else if(max - min > 4){//如果最大元素和最小元素差大于4，则不等组成顺子
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        PokeSort p = new PokeSort();
        int[] arr = {3,0,0,0,0};
        boolean bool = p.isContinuous(arr);
        System.out.println(bool);
    }
}
