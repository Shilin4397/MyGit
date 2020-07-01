package gitIrony.aroundLock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dict = new HashSet<>();
        for (String s:deadends) {
            dict.add(s);
        }

        //判断0000
        if(dict.contains("0000"))
            return -1;
        Queue<String> q = new LinkedList<>();
        Set<String> flag = new HashSet<>();

        q.add("0000");
        //标记
        flag.add("0000");

        int step = 0;
        while (!q.isEmpty()){
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String curStr = q.poll();
                if(curStr.equals(target))
                    return step;
                for (int j = 0; j < 4; j++) {
                    char newC1 = curStr.charAt(j);
                    char newC2 = curStr.charAt(j);

                    if(newC1 == '9')
                        newC1 = '0';
                    else
                        ++newC1;
                    if(newC2 == '0')
                        newC2 = '9';
                    else
                        --newC2;
                    StringBuilder newStr1 = new StringBuilder(curStr);
                    StringBuilder newStr2 = new StringBuilder(curStr);

                    newStr1.setCharAt(j,newC1);
                    newStr2.setCharAt(j,newC2);
                    if(!dict.contains(newStr1.toString()) && !flag.contains(newStr1.toString())) {
                        q.offer(newStr1.toString());
                        flag.add(newStr1.toString());
                    }
                    if (!dict.contains(newStr2.toString()) && !flag.contains(newStr2.toString())) {
                        q.offer(newStr2.toString());
                        flag.add(newStr2.toString());
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
