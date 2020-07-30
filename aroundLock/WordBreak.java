import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
// 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
//例如:
//给定s=“leetcode”；
//dict=["leet", "code"].
//返回true，因为"leetcode"可以被分割成"leet code".

public class WordBreak {
    public boolean wordBreakFun(String s, Set<String> dict) {
        boolean[] flag = new boolean[s.length()+1];
        flag[0] = true;//初始化状态
        for(int i = 1; i < s.length()+1; i++) {
            for(int j = i-1; j >= 0; j--) {
                //flag[i] :flag[j]可以被分割，并且，[j,i-1]可以在词典中被找到则为true
                //否则为false
                if(flag[j] && dict.contains(s.substring(j,i))){
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[flag.length-1];
    }
}